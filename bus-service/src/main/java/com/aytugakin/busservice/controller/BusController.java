package com.aytugakin.busservice.controller;

import com.aytugakin.busservice.controller.dto.AddBusRequest;
import com.aytugakin.busservice.controller.dto.TravelBusRequest;
import com.aytugakin.busservice.controller.dto.TravelBusResponse;
import com.aytugakin.busservice.service.BusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/bus")
public class BusController {

    private final BusService busService;

    @PostMapping
    public ResponseEntity<String> scrapingBusData(@RequestBody AddBusRequest addBusRequest) {
        return ResponseEntity.ok(busService.scrapingBusData(addBusRequest));
    }

    @GetMapping("/getCheapestBus")
    public ResponseEntity<TravelBusResponse> getCheapestBus(@RequestBody TravelBusRequest travelBusRequest) {
        return ResponseEntity.ok(busService.getCheapestBus(travelBusRequest));
    }
}
