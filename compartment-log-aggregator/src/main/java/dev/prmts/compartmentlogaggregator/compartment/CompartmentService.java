package dev.prmts.compartmentlogaggregator.compartment;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CompartmentService {
    public WebClient webClient = WebClient.create("http://localhost:8080/compartments");

    public Mono<Compartment> getCompartmentById(String id) {
        return webClient.get()
                .uri(String.format("/%s", id))
                .retrieve()
                .bodyToMono(Compartment.class);
    }
}
