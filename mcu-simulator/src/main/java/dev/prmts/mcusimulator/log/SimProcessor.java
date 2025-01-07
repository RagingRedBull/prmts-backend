package dev.prmts.mcusimulator.log;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import static dev.prmts.mcusimulator.log.MessagingConfig.MQTT_TOPIC;

@Component
@RequiredArgsConstructor
@Log4j2
public class SimProcessor {
    private final RabbitTemplate template;

    public void send(McuLog mcuLog) {
        log.info("Sending mcu log... {}", mcuLog);
        template.convertAndSend(MQTT_TOPIC, mcuLog);
    }
}
