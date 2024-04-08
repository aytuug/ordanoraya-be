package com.aytugakin.travelservice.controller;

import com.aytugakin.travelservice.controller.dto.TravelRequest;
import com.aytugakin.travelservice.controller.dto.TravelResponse;
import com.aytugakin.travelservice.service.TravelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/travel")
public class TravelController {
    private final TravelService travelService;
    @PostMapping
    public ResponseEntity<TravelResponse> checkTravel(@RequestBody TravelRequest travelRequest) {
        return ResponseEntity.ok(travelService.checkTravel(travelRequest));
    }
}
