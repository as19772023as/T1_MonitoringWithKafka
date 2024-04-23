package ru.strebkov.consumermetrics.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class MeasurementsEntity {
    @Column(name = "statistic")
    private String statistic;
    @Column(name = "value")
    private Float value;
}
