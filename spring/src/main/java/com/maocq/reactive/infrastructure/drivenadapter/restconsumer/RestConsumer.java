package com.maocq.reactive.infrastructure.drivenadapter.restconsumer;

import com.maocq.reactive.domain.model.user.User;
import com.maocq.reactive.domain.model.user.gateways.UserGateway;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class RestConsumer implements UserGateway {

    public RestConsumer(WebClient client) {
        this.client = client;
    }

    private final WebClient client;

    @RegisterReflectionForBinding(User.class)
    public Mono<User> get(int latency) {
        return client
                .get()
                .uri("/{latency}", latency)
                .retrieve()
                .bodyToMono(User.class);
    }
}