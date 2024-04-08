package com.aytugakin.gw.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/travelServiceFallBack")
    public String travelServiceFallback() {
        return "Travel Service is down!";
    }

    @GetMapping("/carServiceFallBack")
    public String carServiceFallBack() {
        return "Car Service is down!";
    }

    @GetMapping("/busServiceFallBack")
    public String busServiceFallBack() {
        return "Bus Service is down!";
    }

}
