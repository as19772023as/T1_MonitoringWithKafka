package ru.strebkov.producermetrics.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeasurementsDto {

    @NotNull
    private String statistic;
    @NotNull
    private Float value;

}
