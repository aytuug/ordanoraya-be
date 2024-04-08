package com.aytugakin.travelservice.external.client;

import com.aytugakin.travelservice.external.model.TravelBusRequest;
import com.aytugakin.travelservice.external.model.TravelBusResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "bus-service/api/bus")
public interface BusService {

    @PostMapping("/getCheapestBus")
    ResponseEntity<TravelBusResponse> getCheapestBus(@RequestBody TravelBusRequest travelBusRequest);
}
