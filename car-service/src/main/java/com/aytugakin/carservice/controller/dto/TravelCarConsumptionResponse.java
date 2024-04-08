package com.aytugakin.carservice.controller.dto;

import lombok.Builder;

@Builder
public record TravelCarConsumptionResponse(
        Double price
) {
}
