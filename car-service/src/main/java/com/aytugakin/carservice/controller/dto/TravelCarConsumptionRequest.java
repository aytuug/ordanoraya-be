package com.aytugakin.carservice.controller.dto;

import com.aytugakin.carservice.entity.FuelType;
import lombok.Builder;

@Builder
public record TravelCarConsumptionRequest(
        Double distance,
        String city,
        String county,
        FuelType fuelType
) {
}
