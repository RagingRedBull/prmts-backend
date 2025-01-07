package dev.prmts.compartmentlogaggregator.compartmentlog;

import dev.prmts.compartmentlogaggregator.compartment.CompartmentService;
import dev.prmts.compartmentlogaggregator.log.LogService;
import dev.prmts.compartmentlogaggregator.log.SensorLog;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@Log4j2
public class CompartmentLogHandler  {
    private final CompartmentService compartmentService;
    private final LogService logService;

    public Mono<ServerResponse> handle(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromProducer(getCompartmentLogById(request.pathVariable("id")), Flux.class));
    }

    private Flux<SensorLog> getCompartmentLogById(String id) {
        return compartmentService.getCompartmentById(id)
                .flatMapMany(compartment -> logService.getMcuLog(compartment.detectorUnits()));
    }
}
