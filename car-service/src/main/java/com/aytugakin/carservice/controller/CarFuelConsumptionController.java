package com.aytugakin.carservice.controller;

import com.aytugakin.carservice.controller.dto.AddFuelRequest;
import com.aytugakin.carservice.controller.dto.TravelCarConsumptionRequest;
import com.aytugakin.carservice.controller.dto.TravelCarConsumptionResponse;
import com.aytugakin.carservice.service.CarFuelConsumptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/car")
public class CarFuelConsumptionController {

    private final CarFuelConsumptionService carFuelConsumptionService;

    @PostMapping
    public ResponseEntity<String> scrapingFuelPrice(@RequestBody AddFuelRequest addFuelRequest) {
        return ResponseEntity.ok(carFuelConsumptionService.scrapingFuelData(addFuelRequest));
    }

    @PostMapping("/getCalculateCarConsumption")
    public ResponseEntity<TravelCarConsumptionResponse> getCalculateCarConsumption(@RequestBody TravelCarConsumptionRequest travelCarConsumptionRequest) {
        return ResponseEntity.ok(carFuelConsumptionService.getCalculateCarConsumption(travelCarConsumptionRequest));
    }

}
