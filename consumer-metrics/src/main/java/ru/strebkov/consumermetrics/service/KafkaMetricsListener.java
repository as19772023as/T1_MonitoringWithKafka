package ru.strebkov.consumermetrics.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.strebkov.commonlib.dto.MetricDTO;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaMetricsListener {
    private final MetricsService metricService;

    @KafkaListener(id = "MetricGroup", topics = "metrics-topic")
    public void listen(MetricDTO metric){
        log.info("Received: {}, ----_____________  объект: {}", metric.getName(), metric.toString());
        if (metric.getName().startsWith("fail")){
            throw new RuntimeException();
        }
        log.info("Ok");

       metricService.saveMetric(metric);
    }

    @KafkaListener(id = "dltGroup", topics = "topic.DLT")
    public void dltListen(byte[] in){
        log.info("Received from dlt: {}", new String(in));
    }
}
