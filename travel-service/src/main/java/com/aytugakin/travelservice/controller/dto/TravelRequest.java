package com.aytugakin.travelservice.controller.dto;

import com.aytugakin.travelservice.external.model.FuelType;
import lombok.Builder;

@Builder
public record TravelRequest(
        String originCity,
        String originCityCode,
        String originCounty,
        String originCountyCode,
        String destinationCode,
        String destination,
        Double distance,
        Double fuelConsumption,
        FuelType fuelType
) {
}
