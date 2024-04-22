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
@Table(schema = "t1_kafka", name = "statistic")
public class StatisticName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "statistic", cascade = CascadeType.ALL)
    private List<Measurement> measurements;
}
