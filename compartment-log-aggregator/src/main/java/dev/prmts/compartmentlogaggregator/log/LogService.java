package dev.prmts.compartmentlogaggregator.log;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class LogService {
    private final WebClient webClient = WebClient.create("http://localhost:9000/logs");

    public Flux<SensorLog> getMcuLog(Set<String> macAddresses) {
        return webClient.post()
                .uri("/compartment")
                .body(BodyInserters.fromValue(macAddresses))
                .retrieve()
                .bodyToFlux(SensorLog.class);
    }
}
