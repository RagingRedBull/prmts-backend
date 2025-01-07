package dev.prmts.gateway.route;

import dev.prmts.gateway.predicate.IsWebsocketPredicate;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
@RequiredArgsConstructor
public class GatewayRouteConfig {
    private final IsWebsocketPredicate isWebsocketPredicate;
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/floors/**")
                        .uri("http://localhost:9090/floors"))
                .route(p -> p.path("/compartments/**")
                        .uri("http://localhost:9091/compartments"))
                .route(p -> p.path("/logs/compartments/**")
                        .filters(rw -> rw.rewritePath("/logs/compartments/(?<segment>.*)", "/router-logs/${segment}"))
                        .uri("http://localhost:9092/router-logs/"))
                .route(p -> p.path("/log")
                        .uri("ws://localhost:9000/log"))
                .build();
    }
}
