package com.aytugakin.gw.filters;

import com.aytugakin.gw.external.client.SpiderService;
import com.aytugakin.gw.external.model.OperationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Component
@RequiredArgsConstructor
@Slf4j
public class OperationCodeFilter implements GlobalFilter {

    private final SpiderService spiderService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String operationCode = exchange.getRequest().getHeaders().getFirst("operation-code");

        if (operationCode == null) {
            exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
            return exchange.getResponse().setComplete();
        }

        return spiderService.getOperationByOperationCodeAsync(operationCode)
                .doOnTerminate(() -> log.info("WebClient yanıtı tamamlandı."))
                .flatMap(operationResponse -> {
                    if (operationResponse == null || operationResponse.returnCode().equals(0)) {
                        exchange.getResponse().getHeaders().add("error-message", "Operasyon kodu geçersiz");
                        exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
                        return exchange.getResponse().setComplete();
                    }
                    return chain.filter(exchange);
                })
                .onErrorResume(error -> {
                    log.error("WebClient Error: {}", error.getMessage());
                    exchange.getResponse().setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
                    return exchange.getResponse().setComplete();
                });
    }


}
