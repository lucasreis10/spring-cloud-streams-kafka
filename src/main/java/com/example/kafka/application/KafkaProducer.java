package com.example.kafka.application;

import com.example.kafka.infrastructure.kafka.EventoKafka;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;


@Component
public class KafkaProducer {

    @Autowired
    private StreamBridge streamBridge;
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    public void sendMessage(EventoKafka evento) {
        String BINDING_NAME = "producer-out-0";
        String payload = evento.converterToJson();

        streamBridge.send(BINDING_NAME, payload);
        LOGGER.info("### Evento enviado ###");
        LOGGER.info("### payload: " + payload + " ###");
    }


}
