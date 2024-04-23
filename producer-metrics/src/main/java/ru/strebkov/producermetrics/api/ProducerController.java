package ru.strebkov.producermetrics.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.strebkov.producermetrics.service.ProducerService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class ProducerController {
    private final ProducerService producerService;

    @PostMapping("/metrics")
    public ResponseEntity<String> sendMetrics(@RequestParam(name = "metricName", required = false) String metricName) {
        return ResponseEntity.ok("Метрика: " + metricName + " - отправлена: " + producerService.sendMetrics(metricName));
    }

}
