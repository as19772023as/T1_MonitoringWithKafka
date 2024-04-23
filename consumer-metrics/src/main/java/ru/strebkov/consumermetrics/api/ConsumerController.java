package ru.strebkov.consumermetrics.api;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.strebkov.consumermetrics.dto.MetricDTO;
import ru.strebkov.consumermetrics.exception.ErrorMessage;

import java.util.List;
import java.util.Optional;

@RestController
public interface ConsumerController {


    @GetMapping
    @Operation(summary = "Получить все  метрики")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Список всех метрик получен",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = MetricDTO.class))),
            @ApiResponse(
                    responseCode = "400",
                    description = "Вероятно плохой запрос",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorMessage.class))),
            @ApiResponse(
                    responseCode = "500",
                    description = "Ошибка на стороне сервера",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorMessage.class)))
    })
    public ResponseEntity<List<MetricDTO>> getAllMetrics();


    @GetMapping
    @Operation(summary = "Получить метрику по id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Метрика получена",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = MetricDTO.class))),
            @ApiResponse(
                    responseCode = "400",
                    description = "Вероятно плохой запрос",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorMessage.class))),
            @ApiResponse(
                    responseCode = "500",
                    description = "Ошибка на стороне сервера",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorMessage.class)))
    })
    public ResponseEntity<Optional<MetricDTO>> getMetricById(
            @Parameter(description = "id метрика для получения", required = true)
            @PathVariable Long id);

}
