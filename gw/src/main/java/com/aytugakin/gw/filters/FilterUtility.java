package com.aytugakin.gw.filters;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import org.springframework.http.HttpHeaders;
import java.util.List;

@Component
public class FilterUtility {

    public static final String REQUEST_ID = "ordanoraya-request-id";

    public String getCorrelationId(HttpHeaders requestHeaders) {
        if (requestHeaders.get(REQUEST_ID) != null) {
            List<String> requestHeaderList = requestHeaders.get(REQUEST_ID);
            return requestHeaderList.stream().findFirst().get();
        } else {
            return null;
        }
    }

    public ServerWebExchange setRequestHeader(ServerWebExchange exchange, String name, String value) {
        return exchange.mutate().request(exchange.getRequest().mutate().header(name, value).build()).build();
    }

    public ServerWebExchange setCorrelationId(ServerWebExchange exchange, String correlationId) {
        return this.setRequestHeader(exchange, REQUEST_ID, correlationId);
    }

}