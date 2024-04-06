package com.aytugakin.busservice.exception;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ErrorDetails(
        LocalDateTime localDateTime,
        String message,
        String path,
        String errorCode
) {
}
