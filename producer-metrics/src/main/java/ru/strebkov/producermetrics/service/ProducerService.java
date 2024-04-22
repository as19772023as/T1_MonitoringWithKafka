package ru.strebkov.producermetrics.service;


import ru.strebkov.producermetrics.dto.MetricDTO;

public interface ProducerService {
    MetricDTO sendMetrics(String metricName);
}
