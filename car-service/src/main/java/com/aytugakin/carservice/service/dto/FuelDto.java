package com.aytugakin.carservice.service.dto;

import lombok.Builder;

@Builder
public record FuelDto(
        String city,
        String county,
        String cityCode,
        String countyCode,
        Double gasolinePrice,
        Double dieselPrice,
        Double lpgPrice
) {
}
