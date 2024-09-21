package com.aytugakin.travelservice.service;

import com.aytugakin.travelservice.repository.TravelRepository;
import com.aytugakin.travelservice.controller.dto.TravelRequest;
import com.aytugakin.travelservice.controller.dto.TravelResponse;
import com.aytugakin.travelservice.entity.Travel;
import com.aytugakin.travelservice.exception.ResourceNotFoundException;
import com.aytugakin.travelservice.external.client.BusService;
import com.aytugakin.travelservice.external.client.CarService;
import com.aytugakin.travelservice.external.model.TravelBusRequest;
import com.aytugakin.travelservice.external.model.TravelBusResponse;
import com.aytugakin.travelservice.external.model.TravelCarConsumptionRequest;
import com.aytugakin.travelservice.external.model.TravelCarConsumptionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TravelService {

    private final TravelRepository travelRepository;
    private final CarService carService;
    private final BusService busService;

    public TravelResponse checkTravel(TravelRequest travelRequest) {

        TravelBusResponse travelBusResponse = busService.getCheapestBus(TravelBusRequest.builder()
                .originCode(travelRequest.originCityCode())
                .destinationCode(travelRequest.destinationCode()).build()).getBody();

        TravelCarConsumptionResponse travelCarConsumptionResponse = carService.getCalculateCarConsumption(TravelCarConsumptionRequest.builder()
                        .carConsumption(travelRequest.fuelConsumption())
                        .distance(travelRequest.distance())
                        .city(travelRequest.originCity())
                        .county(travelRequest.originCounty())
                        .cityCode(travelRequest.originCityCode())
                        .countyCode(travelRequest.originCountyCode())
                        .fuelType(travelRequest.fuelType())
                .build()).getBody();

        if (Objects.nonNull(travelBusResponse) && Objects.nonNull(travelCarConsumptionResponse)) {
            travelRepository.save(Travel.builder()
                    .carConsumption(travelRequest.fuelConsumption())
                    .distance(travelRequest.distance())
                    .destination(travelRequest.destination())
                    .destinationCode(travelRequest.destinationCode())
                    .originCounty(travelRequest.originCounty())
                    .originCountyCode(travelRequest.originCountyCode())
                    .originCity(travelRequest.originCity())
                    .originCityCode(travelRequest.originCityCode())
                    .build());

            return TravelResponse.builder()
                    .travelBusResponse(travelBusResponse)
                    .travelCarConsumptionResponse(travelCarConsumptionResponse).build();

        }
        throw new ResourceNotFoundException("Bus Or CarConsumption not found");
    }
}
