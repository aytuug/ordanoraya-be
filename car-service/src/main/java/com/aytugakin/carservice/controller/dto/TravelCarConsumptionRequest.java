package com.aytugakin.carservice.controller.dto;

import com.aytugakin.carservice.entity.FuelType;
import lombok.Builder;

@Builder
public record TravelCarConsumptionRequest(
        String fuelConsumption,
        String distance,
        FuelType fuelType
) {
}
