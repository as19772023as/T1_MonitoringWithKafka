package ru.strebkov.consumermetrics.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.strebkov.consumermetrics.dto.MetricDTO;
import ru.strebkov.consumermetrics.service.MetricsService;

import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/metrics")
public class ConsumerControllerImpl implements ConsumerController {
    private final MetricsService metricService;

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<MetricDTO>> getAllMetrics() {
        return ResponseEntity.ok(metricService.getAllMetrics());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Optional<MetricDTO>> getMetricById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(metricService.getMetricsById(id), HttpStatus.OK);
    }

}
