package com.aytugakin.travelservice.external.model;

import lombok.Builder;

@Builder
public record TravelBusRequest(
        String destination,
        String origin
) {
}
