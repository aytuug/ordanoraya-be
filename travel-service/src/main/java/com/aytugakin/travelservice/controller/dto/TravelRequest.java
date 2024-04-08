package com.aytugakin.travelservice.controller.dto;

import com.aytugakin.travelservice.external.model.FuelType;
import lombok.Builder;

@Builder
public record TravelRequest(
        String originCity,
        String originCounty,
        String destination,
        Double distance,
        Double fuelConsumption,
        FuelType fuelType
) {
}
