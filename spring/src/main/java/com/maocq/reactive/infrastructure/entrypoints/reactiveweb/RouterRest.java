package com.maocq.reactive.infrastructure.entrypoints.reactiveweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterRest {

    @Bean
    public RouterFunction<ServerResponse> routerFunction(Handler handler) {
        return route(GET("/api/hello"), handler::hello)
                .andRoute(GET("/api/case-one"), handler::caseOne)
                .andRoute(GET("/api/case-two"), handler::caseTwo)
                .andRoute(GET("/api/case-three"), handler::caseThree)
                .andRoute(GET("/api/case-four"), handler::caseFour);
    }
}
