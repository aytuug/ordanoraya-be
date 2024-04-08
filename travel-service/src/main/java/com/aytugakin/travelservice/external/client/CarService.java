package com.aytugakin.travelservice.external.client;

import com.aytugakin.travelservice.external.model.TravelCarConsumptionRequest;
import com.aytugakin.travelservice.external.model.TravelCarConsumptionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "car-service/api/car")
public interface CarService {

    @PostMapping("/getCalculateCarConsumption")
    ResponseEntity<TravelCarConsumptionResponse> getCalculateCarConsumption(@RequestBody TravelCarConsumptionRequest travelCarConsumptionRequest);
}
