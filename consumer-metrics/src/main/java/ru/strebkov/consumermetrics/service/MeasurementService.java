package ru.strebkov.consumermetrics.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.strebkov.commonlib.dto.MeasurementsDto;
import ru.strebkov.consumermetrics.model.Measurement;
import ru.strebkov.consumermetrics.model.StatisticName;
import ru.strebkov.consumermetrics.repository.MetricRepository;

//@Service
//@RequiredArgsConstructor
//@Transactional
public class MeasurementService {
//    private final MeasurementRepository measurementRepository;
//    private final StatisticNameRepository statisticNameRepository;


//
//    public Measurement saveMeasurements(MeasurementsDto measurement){
//        StatisticName statisticName = findOrSaveStatisticName(measurement.statistic());
//
//        return measurementRepository.save(Measurement.builder()
//                .statistic(statisticName)
//                .value(measurement.value())
//                .build());
//    }
//
//    private StatisticName findOrSaveStatisticName(String name) {
//        StatisticName statisticName = statisticNameRepository.findStatisticNameByName(name);
//        if (statisticName == null) {
//            statisticName = statisticNameRepository.save(StatisticName.builder()
//                    .name(name)
//                    .build());
//        }
//        return statisticName;
//    }
}
