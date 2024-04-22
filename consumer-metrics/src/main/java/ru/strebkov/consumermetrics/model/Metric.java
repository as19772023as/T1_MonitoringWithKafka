package ru.strebkov.consumermetrics.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

//@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "t1_kafka", name = "metrics")
public class Metric {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "name_id")
    private MetricName name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "base_unit_id")
    private BaseUnit baseUnit;

    @OneToMany(mappedBy = "metrics", cascade = CascadeType.ALL)
    private List<Measurement> measurements;
}
