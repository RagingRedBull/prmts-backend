package dev.prmts.mculogger.logging;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogMessagingConfig {
    public static final String MQTT_TOPIC = "outTopic";

    @Bean
    public Queue mcuLogQueue() {
        return new Queue(MQTT_TOPIC);
    }
    @Bean
    public Binding mqttBinding() {
        return new Binding(MQTT_TOPIC, Binding.DestinationType.QUEUE, "amq.topic", MQTT_TOPIC, null);
    }

    @Bean
    public Jackson2JsonMessageConverter converter() {
        Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();
        converter.setNullAsOptionalEmpty(true);
        return converter;
    }
}
