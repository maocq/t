package com.maocq.reactive.domain.model.user.gateways;

import com.maocq.reactive.domain.model.user.User;
import reactor.core.publisher.Mono;

public interface UserGateway {
    Mono<User> get(int latency);
}
