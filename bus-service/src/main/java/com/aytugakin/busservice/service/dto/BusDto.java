package com.aytugakin.busservice.service.dto;

import lombok.Builder;

@Builder
public record BusDto(
        String destination,
        String origin,
        String company,
        Double price
) {

}
