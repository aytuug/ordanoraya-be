package com.aytugakin.travelservice.external.client;

import com.aytugakin.travelservice.exception.UnavailableExternalServiceException;
import com.aytugakin.travelservice.external.model.TravelBusRequest;
import com.aytugakin.travelservice.external.model.TravelBusResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "BUS-SERVICE")
public interface BusService {

    @PostMapping("/api/bus/getCheapestBus")
    ResponseEntity<TravelBusResponse> getCheapestBus(@RequestBody TravelBusRequest travelBusRequest);

    default void fallback(Exception e) {
        throw new UnavailableExternalServiceException("Payment Service");
    }
}
