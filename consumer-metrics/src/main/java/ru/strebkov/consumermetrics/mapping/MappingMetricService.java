package ru.strebkov.consumermetrics.mapping;

import org.springframework.stereotype.Component;
import ru.strebkov.consumermetrics.dto.MeasurementsDto;
import ru.strebkov.consumermetrics.dto.MetricDTO;
import ru.strebkov.consumermetrics.model.MeasurementsEntity;
import ru.strebkov.consumermetrics.model.MetricsEntity;

import java.util.Collections;

@Component
public class MappingMetricService {
    public MetricsEntity mapToMetricEntity(MetricDTO dto) {

        MetricsEntity entity = new MetricsEntity();

        MeasurementsEntity measurements = new MeasurementsEntity();
        measurements.setStatistic(dto.getMeasurements().iterator().next().getStatistic());
        measurements.setValue(dto.getMeasurements().iterator().next().getValue());

        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setBaseUnit(dto.getBaseUnit());
        entity.setMeasurements(measurements);

        return entity;
    }

    public MetricDTO mapToMetricDto(MetricsEntity entity) {
        MetricDTO dto = new MetricDTO();

        MeasurementsDto measurementsDto = new MeasurementsDto();
        measurementsDto.setStatistic(entity.getMeasurements().getStatistic());
        measurementsDto.setValue(entity.getMeasurements().getValue());

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setBaseUnit(entity.getBaseUnit());
        dto.setMeasurements(Collections.singletonList(measurementsDto));

        return dto;
    }

}
