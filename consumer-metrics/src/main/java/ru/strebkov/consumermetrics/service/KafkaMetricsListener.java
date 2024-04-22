package ru.strebkov.consumermetrics.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.strebkov.consumermetrics.dto.MetricDTO;


@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaMetricsListener {
    private final MetricsService metricService;

    @KafkaListener(id = "MetricGroup", topics = "metrics-topic")
    public void listen(MetricDTO metric) {

        log.info("Начало Metric = {}  объект = {}_____________", metric.getName(), metric.toString());

        if (metric.getName().startsWith("fail")) {
            throw new RuntimeException();
        }
        log.info("Ok");

         metricService.saveMetric(metric);
    }

    @KafkaListener(id = "dltGroup", topics = "topic.DLT")
    public void dltListen(byte[] in) {
        log.info("Received from dlt: {}", new String(in));
    }
}
