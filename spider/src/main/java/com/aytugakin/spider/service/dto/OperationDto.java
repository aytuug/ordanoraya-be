package com.aytugakin.spider.service.dto;


import lombok.Builder;

@Builder
public record OperationDto(
        String operationCode,
        String callSystem,
        boolean isActive
) {
}
