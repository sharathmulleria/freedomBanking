package com.freedomBanking.api_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
public class GatewayRoutesConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("auth-public", r -> r
                        .path("/api/auth/register", "api/auth/login")
                        .and()
                        .method(HttpMethod.POST)
                        .filters(f -> f
                                .stripPrefix(2)
                                .requestRateLimiter(c -> c
                                        .setRateLimiter(redisRateLimiter())))
                        .uri("lb://AUTH-MANAGEMENT")
                )
    }
}
