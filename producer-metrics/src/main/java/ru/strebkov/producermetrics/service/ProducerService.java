package ru.strebkov.producermetrics.service;

import ru.strebkov.commonlib.dto.MetricDTO;

public interface ProducerService {
    MetricDTO sendMetrics(String metricName);
}
