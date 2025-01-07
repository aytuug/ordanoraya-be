package com.aytugakin.gw.external.client;

import com.aytugakin.gw.external.model.OperationResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class SpiderService {

    private final WebClient webClient;

    public SpiderService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8083").build();
    }

    public Mono<OperationResponse> getOperationByOperationCodeAsync(String operationCode) {
        return webClient.get()
                .uri("/api/operation/{operationCode}", operationCode)
                .retrieve()
                .bodyToMono(OperationResponse.class);
    }
}
