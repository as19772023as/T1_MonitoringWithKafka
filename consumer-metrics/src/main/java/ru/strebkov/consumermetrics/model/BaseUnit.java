package ru.strebkov.consumermetrics.model;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Table(schema = "t1_kafka", name = "base_unit")
public class BaseUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Schema(description = "id единицы измерения", example = "1")
    private Long id;

    @Column(name = "name")
    @Schema(description = "Наименование единицы измерения", example = "bytes")
    private String name;

    @OneToMany(mappedBy = "baseUnit", cascade = CascadeType.ALL)
    private List<Metric> metrics;

}
