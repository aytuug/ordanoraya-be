package com.aytugakin.busservice.controller.dto;

import com.aytugakin.busservice.service.dto.BusDto;
import lombok.Builder;

import java.util.List;

@Builder
public record AddBusRequest(
        List<BusDto> busDtoList
) {
}
