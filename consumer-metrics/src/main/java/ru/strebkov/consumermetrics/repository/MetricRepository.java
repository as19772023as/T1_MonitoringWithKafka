package ru.strebkov.consumermetrics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.strebkov.consumermetrics.model.MetricsEntity;

@Repository
public interface MetricRepository  extends JpaRepository<MetricsEntity, Long> {
}
