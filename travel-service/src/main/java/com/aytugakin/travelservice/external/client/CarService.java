package com.aytugakin.travelservice.external.client;

import com.aytugakin.travelservice.exception.UnavailableExternalServiceException;
import com.aytugakin.travelservice.external.model.TravelCarConsumptionRequest;
import com.aytugakin.travelservice.external.model.TravelCarConsumptionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "CAR-SERVICE")
public interface CarService {

    @GetMapping("/api/car/getCalculateCarConsumption")
    ResponseEntity<TravelCarConsumptionResponse> getCalculateCarConsumption(@RequestBody TravelCarConsumptionRequest travelCarConsumptionRequest);

    default void fallback(Exception e) {
        throw new UnavailableExternalServiceException("Payment Service");
    }
}
