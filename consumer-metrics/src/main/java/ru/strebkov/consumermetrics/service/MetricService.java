package ru.strebkov.consumermetrics.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.strebkov.commonlib.dto.MeasurementsDto;
import ru.strebkov.commonlib.dto.MetricDTO;
import ru.strebkov.commonlib.exception.NotFoundException;
import ru.strebkov.consumermetrics.model.BaseUnit;
import ru.strebkov.consumermetrics.model.Measurement;
import ru.strebkov.consumermetrics.model.Metric;
import ru.strebkov.consumermetrics.model.MetricName;

import java.util.Date;
import java.util.List;

//Service
//@RequiredArgsConstructor
@Transactional
public class MetricService {
  //  private final MeasurementService measurementService;

//    private final MetricRepository metricRepository;
//    private final MetricNameRepository metricNameRepository;
//    private final BaseUnitRepository baseUnitRepository;

//    public void saveMetric(MetricDTO metricDTO) {
//        MetricName metricName = findOrSaveMetricName(metricDTO.name());
//
//        BaseUnit baseUnit = null;
//        if (metricDTO.baseUnit() != null) {
//            baseUnit = findOrSaveBaseUnit(metricDTO.baseUnit());
//        }
//
//        Metric metric = metricRepository.save(Metric.builder()
//                .name(metricName)
//                .description(metricDTO.description())
//                .baseUnit(baseUnit)
//                .date(new Date())
//                .build());
//
//        System.out.println(metric.getId());
//
//        for (MeasurementsDto measurementDTO : metricDTO.measurements()) {
//            Measurement measurement = measurementService.saveMeasurements(measurementDTO);
//            measurement.setMetric(metric);
//        }
//    }
//
//    private MetricName findOrSaveMetricName(String name) {
//        MetricName metricName = metricNameRepository.findMetricNameByName(name);
//        if (metricName == null) {
//            metricName = metricNameRepository.save(MetricName.builder()
//                    .name(name)
//                    .build());
//        }
//        return metricName;
//    }
//
//    private BaseUnit findOrSaveBaseUnit(String baseUnitName) {
//        BaseUnit baseUnit = baseUnitRepository.findBaseUnitNameByName(baseUnitName);
//        if (baseUnit == null) {
//            baseUnit = baseUnitRepository.save(BaseUnit.builder()
//                    .name(baseUnitName)
//                    .build());
//        }
//        return baseUnit;
//    }
//
//    public List<MetricDTO> getAllMetrics() {
//        return metricRepository.findAll()
//                .stream()
//                .map(MetricMapper.INSTANCE::toDTO)
//                .toList();
//    }
//
//    public MetricDTO getMetricsById(Long id) {
//        return MetricMapper.INSTANCE.toDTO(metricRepository.findById(id)
//                .orElseThrow(() -> new NotFoundException("Метрик с заданным id не существует")));
//    }
}
