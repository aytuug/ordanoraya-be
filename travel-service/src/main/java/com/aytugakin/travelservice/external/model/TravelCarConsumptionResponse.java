package com.aytugakin.travelservice.external.model;

import lombok.Builder;

@Builder
public record TravelCarConsumptionResponse(
        Double price
) {
}
