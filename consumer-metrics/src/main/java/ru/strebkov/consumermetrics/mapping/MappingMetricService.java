package ru.strebkov.consumermetrics.mapping;

import org.springframework.stereotype.Component;

import ru.strebkov.consumermetrics.dto.MetricDTO;
import ru.strebkov.consumermetrics.model.MeasurementsEntity;
import ru.strebkov.consumermetrics.model.MetricsEntity;

@Component
public class MappingMetricService {
    public MetricsEntity mapToMetricEntity(MetricDTO dto) {

        MetricsEntity entity = new MetricsEntity();

//        MeasurementsEntity measurements = new MeasurementsEntity();
//        measurements.setStatistic(dto.getMeasurements().get(0).statistic());
//        measurements.setValue(dto.getMeasurements().get(1).value());

//        String statistic = dto.getMeasurements().get(0).toString();
//        Float f = dto.getMeasurements().get(1).value();

        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setBaseUnit(dto.getBaseUnit());


        return entity;
    }

    public MetricDTO mapToMetricDto(MetricsEntity entity) {
        MetricDTO dto = new MetricDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setBaseUnit(entity.getBaseUnit());
        // entity.setMeasurements(measurements);

        return dto;
    }
}
