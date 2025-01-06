package com.aytugakin.gw.config;

import com.aytugakin.gw.data.RouteEntity;
import com.aytugakin.gw.filters.AddDateHeaderFilter;
import com.aytugakin.gw.filters.HeaderOperationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class GatewayConfig {

    private final AddDateHeaderFilter addDateHeaderFilter;
    private final RouteEntity routeConfiguration;
    private final HeaderOperationFilter headerOperationFilter;

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();

        for (RouteEntity.RouteConfig route : routeConfiguration.getRoutes()) {
            routes.route(route.getId(), r -> r.path(route.getPredicates().get(0).replaceFirst("Path=", ""))
                    .filters(f -> f
                            .filter(addDateHeaderFilter)
                            .filter(headerOperationFilter.apply(new HeaderOperationFilter.Config()))
                            .addResponseHeader("operation-result", "result-200-gw")
                    )
                    .uri(route.getUri()));
        }

        return routes.build();
    }

}
