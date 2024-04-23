package ru.strebkov.producermetrics.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeasurementsDto {

    private String statistic;
    private Float value;

}
