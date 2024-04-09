package com.aytugakin.busservice.service.dto;

import lombok.Builder;

@Builder
public record BusDto(
        String destination,
        String destinationCode,
        String origin,
        String originCode,
        String company,
        Double price
) {

}
