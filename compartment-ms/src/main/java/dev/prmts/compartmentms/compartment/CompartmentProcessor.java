package dev.prmts.compartmentms.compartment;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompartmentProcessor {
    private final CompartmentService compartmentService;

    @RabbitListener(queues = "compartment-create-queue")
    public void createQueue(CompartmentDto compartment) {

    }
}
