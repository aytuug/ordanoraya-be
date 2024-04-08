package com.aytugakin.travelservice.external.model;

import lombok.Builder;

@Builder
public record TravelCarConsumptionRequest(
        Double distance,
        String city,
        String county,
        Double carConsumption,
        FuelType fuelType
) {
}
