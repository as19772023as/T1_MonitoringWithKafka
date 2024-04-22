package ru.strebkov.consumermetrics.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "t1_kafka", name = "metric_name")
public class MetricName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "name", cascade = CascadeType.ALL)
    private List<Metric> metrics;
}
