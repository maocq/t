package com.maocq.reactive.infrastructure.entrypoints.reactiveweb;

import com.maocq.reactive.domain.usecase.ScenariosUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class Handler {

    private final ScenariosUseCase useCases;

    public Mono<ServerResponse> hello(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue("Hello world!");
    }

    public Mono<ServerResponse> caseOne(ServerRequest serverRequest) {
        var latency = serverRequest.queryParam("latency").map(Integer::valueOf).orElse(0);

        return useCases.caseOne(latency)
                .flatMap(response -> ServerResponse.ok().bodyValue(response));
    }

    public Mono<ServerResponse> caseTwo(ServerRequest serverRequest) {
        var number = serverRequest.queryParam("number").map(Integer::valueOf).orElse(10_000);

        return useCases.caseTwo(number)
                .flatMap(response -> ServerResponse.ok().bodyValue(response));
    }

    public Mono<ServerResponse> caseThree(ServerRequest serverRequest) {
        return useCases.caseThree(4000)
                .flatMap(response -> ServerResponse.ok().bodyValue(response));
    }

    public Mono<ServerResponse> caseFour(ServerRequest serverRequest) {
        var latency = serverRequest.queryParam("latency").map(Integer::valueOf).orElse(0);

        return useCases.caseFour(4000, latency)
                .flatMap(response -> ServerResponse.ok().bodyValue(response));
    }
}
