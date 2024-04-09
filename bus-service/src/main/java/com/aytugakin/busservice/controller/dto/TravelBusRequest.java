package com.aytugakin.busservice.controller.dto;

import lombok.Builder;

@Builder
public record TravelBusRequest(
        String destinationCode,
        String originCode
) {
}
