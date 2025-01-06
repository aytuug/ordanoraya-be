package com.aytugakin.gw.data;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "spring.cloud.gateway")
public class RouteEntity {

    private List<RouteConfig> routes = new ArrayList<>();

    @Setter
    @Getter
    public static class RouteConfig {
        private String id;
        private String uri;
        private List<String> predicates;
    }
}
