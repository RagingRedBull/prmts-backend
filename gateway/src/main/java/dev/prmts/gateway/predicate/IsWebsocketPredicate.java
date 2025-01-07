package dev.prmts.gateway.predicate;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.util.function.Predicate;

@Component
public class IsWebsocketPredicate extends AbstractRoutePredicateFactory<IsWebsocketPredicate.Config> {

    public IsWebsocketPredicate() {
        super(Config.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return (ServerWebExchange t) -> t.getRequest()
                .getHeaders()
                .containsKey("Sec-WebSocket-Protocol");
    }


    @Validated
    public static class Config {

    }
}
