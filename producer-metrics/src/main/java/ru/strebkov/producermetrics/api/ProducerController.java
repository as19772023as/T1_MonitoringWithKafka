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

    // "application.ready.time",
    //        "application.started.time",
    //        "disk.free",
    //        "disk.total",
    //        "executor.active",
    //        "executor.completed",
    //        "executor.pool.core",
    //        "executor.pool.max",
    //        "executor.pool.size",
    //        "executor.queue.remaining",
    //        "executor.queued",
    //        "http.server.requests.active",
    //        "jvm.buffer.count",
    //        "jvm.buffer.memory.used",
    //        "jvm.buffer.total.capacity",
    //        "jvm.classes.loaded",
    //        "jvm.classes.unloaded",
    //        "jvm.compilation.time",
    //        "jvm.gc.live.data.size",
    //        "jvm.gc.max.data.size",
    //        "jvm.gc.memory.allocated",
    //        "jvm.gc.memory.promoted",
    //        "jvm.gc.overhead",
    //        "jvm.gc.pause",
    //        "jvm.info",
    //        "jvm.memory.committed",
    //        "jvm.memory.max",
    //        "jvm.memory.usage.after.gc",
    //        "jvm.memory.used",
    //        "jvm.threads.daemon",
    //        "jvm.threads.live",
    //        "jvm.threads.peak",
    //        "jvm.threads.started",
    //        "jvm.threads.states",
    //        "logback.events",
    //        "process.cpu.usage",
    //        "process.start.time",
    //        "process.uptime",
    //        "spring.kafka.template",
    //        "system.cpu.count",
    //        "system.cpu.usage",
    //        "tomcat.sessions.active.current",
    //        "tomcat.sessions.active.max",
    //        "tomcat.sessions.alive.max",
    //        "tomcat.sessions.created",
    //        "tomcat.sessions.expired",
    //        "tomcat.sessions.rejected"

}
