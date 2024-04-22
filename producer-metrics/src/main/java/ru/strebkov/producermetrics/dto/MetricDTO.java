package ru.strebkov.producermetrics.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

   // List<MeasurementsDto> measurements;

}
