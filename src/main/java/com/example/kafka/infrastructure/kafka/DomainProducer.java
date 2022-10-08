package com.example.kafka.infrastructure.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;


@Component
public class DomainProducer {

    @Autowired
    private StreamBridge streamBridge;
    private static final Logger LOGGER = LoggerFactory.getLogger(DomainProducer.class);

    public void sendMessage(DomainEvent evento) {
        String BINDING_NAME = "producer-out-0";
        String payload = evento.converterToJson();

        streamBridge.send(BINDING_NAME, payload);
        LOGGER.info("### Evento enviado ###");
        LOGGER.info("### payload: " + payload + " ###");
    }


}
