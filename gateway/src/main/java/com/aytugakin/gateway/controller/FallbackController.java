package com.aytugakin.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {
    @GetMapping("/travelServiceFallBack")
    public String travelServiceFallback() {
        return "Order Service is down!";
    }

    @GetMapping("/carServiceFallBack")
    public String carServiceFallBack() {
        return "Payment Service is down!";
    }

    @GetMapping("/busServiceFallBack")
    public String busServiceFallBack() {
        return "Product Service is down!";
    }
}
