package com.aytugakin.busservice.controller.dto;

import lombok.Builder;

@Builder
public record TravelBusResponse(
        String company,
        Double price
) {
}
