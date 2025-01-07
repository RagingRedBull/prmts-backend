package dev.prmts.compartmentms.compartment;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CompartmentConfig {
    @Bean
    public Queue createCompartmentQueue() {
        return new Queue("compartment-create-queue");
    }

    @Bean
    public Queue deleteCompartmentQueue2() {
        return new Queue("compartment-delete-queue");
    }

    @Bean
    public Jackson2JsonMessageConverter converter() {
        Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();
        converter.setNullAsOptionalEmpty(true);
        return converter;
    }
}
