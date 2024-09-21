package com.aytugakin.gw.config;

import com.aytugakin.gw.filters.AddDateHeaderFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    private final AddDateHeaderFilter addDateHeaderFilter;

    public GatewayConfig(AddDateHeaderFilter addDateHeaderFilter) {
        this.addDateHeaderFilter = addDateHeaderFilter;
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("bus_route", r -> r.path("/api/bus/**")
                        .filters(f -> f.filter(addDateHeaderFilter))
                        .uri("lb://bus-service"))
                .route("car_route", r -> r.path("/api/car/**")
                        .filters(f -> f.filter(addDateHeaderFilter))
                        .uri("lb://car-service"))
                .route("travel_route", r -> r.path("/api/travel/**")
                        .filters(f -> f.filter(addDateHeaderFilter))
                        .uri("lb://travel-service"))
                .build();
    }
}
