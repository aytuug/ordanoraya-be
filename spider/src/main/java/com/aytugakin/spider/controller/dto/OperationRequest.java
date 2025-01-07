package com.aytugakin.spider.controller.dto;

import lombok.Builder;

@Builder
public record OperationRequest(String operationCode, String description) {
}
