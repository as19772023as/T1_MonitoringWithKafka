package ru.strebkov.commonlib.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record MeasurementsDto(
        @NotNull
        String statistic,
        @NotNull
        Float value
) {
}
