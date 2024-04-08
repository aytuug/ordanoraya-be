package com.aytugakin.travelservice.controller.dto;

import com.aytugakin.travelservice.external.model.TravelBusResponse;
import com.aytugakin.travelservice.external.model.TravelCarConsumptionResponse;
import lombok.Builder;

@Builder
public record TravelResponse(
        TravelBusResponse travelBusResponse,
        TravelCarConsumptionResponse travelCarConsumptionResponse
) {
}
