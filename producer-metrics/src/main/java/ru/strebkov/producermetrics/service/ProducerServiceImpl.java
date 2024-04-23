package ru.strebkov.producermetrics.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import ru.strebkov.producermetrics.dto.MetricDTO;
import ru.strebkov.producermetrics.exception.NotFoundException;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProducerServiceImpl implements ProducerService {
    private final KafkaTemplate<Object, Object> kafkaTemplate;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Value("${some.default-port:8081}")
    private String port;


    @Override
    public MetricDTO sendMetrics(String metricName) {
        MetricDTO metric = getMetrics(metricName);
        sendMessage("metrics-topic", metric);

        return metric;
    }

    private MetricDTO getMetrics(String metricName) {
        String endpointUrl = "http://localhost:" + port + "/actuator/metrics/" + metricName;

        ResponseEntity<String> responseEntity;
        try {
            responseEntity = restTemplate.getForEntity(endpointUrl, String.class);
        } catch (HttpClientErrorException e) {
            throw new NotFoundException("Метрика не существует, " +
                    "все метрики доступны по endpoint = /actuator/metrics");
        }

        MetricDTO metricDTO;
        try {
            metricDTO = objectMapper.readValue(responseEntity.getBody(), MetricDTO.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }

        return metricDTO;
    }

    public void sendMessage(String topicName, MetricDTO metricDto) {
        CompletableFuture<SendResult<Object, Object>> future = kafkaTemplate.send(topicName, metricDto);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Отправлено -- message= [{}] with offset=[{}]", metricDto,
                        result.getRecordMetadata().offset());
            } else {
                log.info("Unable to send message= [{}]  due to: {}", metricDto,
                        result.getRecordMetadata().offset());
            }
        });
    }

}

