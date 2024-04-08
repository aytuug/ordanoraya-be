package com.aytugakin.travelservice.external.model;

import lombok.Builder;

@Builder
public record TravelBusResponse(
        String company,
        Double price
) {
}
