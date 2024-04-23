package ru.strebkov.consumermetrics.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.strebkov.consumermetrics.dto.MetricDTO;
import ru.strebkov.consumermetrics.mapping.MappingMetricService;
import ru.strebkov.consumermetrics.model.MetricsEntity;
import ru.strebkov.consumermetrics.repository.MetricRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class MetricsService {

    private final MappingMetricService mappingMetricService;
    private final MetricRepository repository;


    public MetricsEntity saveMetric(MetricDTO metric) {
        MetricsEntity metricsEntity = mappingMetricService.mapToMetricEntity(metric);
        log.info("Service объект: {}",  metricsEntity.toString());
        return repository.save(metricsEntity);
    }


    public List<MetricDTO> getAllMetrics() {
        return repository.findAll().stream()
                .map(mappingMetricService::mapToMetricDto)
                .collect(Collectors.toList());
    }

    public Optional<MetricDTO> getMetricsById(Long id) {
        return Optional.ofNullable(mappingMetricService.mapToMetricDto(repository.findById(id)
                .orElse(new MetricsEntity())));
    }

}
