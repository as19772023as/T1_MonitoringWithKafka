package ru.strebkov.consumermetrics.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "t1_kafka", name = "measurements")
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "value")
    private float value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "metric_id")
    private Metric metric;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statistic_id")
    private StatisticName statistic;
}


