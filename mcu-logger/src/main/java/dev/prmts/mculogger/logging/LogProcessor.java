package dev.prmts.mculogger.logging;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class LogProcessor {
    private final LogService logService;
    private final SimpMessagingTemplate simpMessagingTemplate;
    @RabbitListener(queues = LogMessagingConfig.MQTT_TOPIC)
    public void process(McuLog mcuLog) {
        logService.save(mcuLog);
        simpMessagingTemplate.convertAndSend("/topic/greetings", mcuLog);
    }
}
