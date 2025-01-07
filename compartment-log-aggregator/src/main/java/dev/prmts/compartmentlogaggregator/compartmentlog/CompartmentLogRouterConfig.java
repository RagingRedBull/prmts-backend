package dev.prmts.compartmentlogaggregator.compartmentlog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CompartmentLogRouterConfig {
    @Bean
    public RouterFunction<ServerResponse> compartmentLogRouter(CompartmentLogHandler compartmentLogHandler) {
        return route(GET("/router-logs/{id}")
                .and(accept(MediaType.APPLICATION_JSON)), compartmentLogHandler::handle);
    }
}
