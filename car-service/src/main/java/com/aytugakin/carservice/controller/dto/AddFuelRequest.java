package com.aytugakin.carservice.controller.dto;

import com.aytugakin.carservice.service.dto.FuelDto;
import lombok.Builder;

import java.util.List;

@Builder
public record AddFuelRequest(
        List<FuelDto> fuelDtoList
) {
}
