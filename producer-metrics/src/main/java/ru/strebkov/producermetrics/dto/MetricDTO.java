package ru.strebkov.producermetrics.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MetricDTO {
    private long id;
    @NotNull
    private String name;
    private String description;
    private String baseUnit;

    private List<MeasurementsDto> measurements;

}
