package com.aytugakin.gw.external.model;

import lombok.Builder;

@Builder
public record OperationRequest(String operationCode, String description) {
}
