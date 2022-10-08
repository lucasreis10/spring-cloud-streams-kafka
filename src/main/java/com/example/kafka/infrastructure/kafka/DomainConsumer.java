package com.example.kafka.infrastructure.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class DomainConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(DomainConsumer.class);

    @Bean
    public Consumer<String> consumer() {
        return evento -> {
            LOGGER.info("### Evento recebido ### ");
            LOGGER.info("Evento recebido: " + evento);
        };
    }

}
