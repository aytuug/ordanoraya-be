package com.aytugakin.gw.external.model;

public record OperationResponse(
        Integer returnCode,
        String returnMessage
) {
}
