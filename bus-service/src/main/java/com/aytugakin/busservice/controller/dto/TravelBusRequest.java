package com.aytugakin.busservice.controller.dto;

import lombok.Builder;

@Builder
public record TravelBusRequest(
        String destination,
        String origin
) {
}
