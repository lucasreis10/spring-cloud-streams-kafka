package com.example.kafka.infrastructure.kafka;

import com.example.kafka.application.evento.EventoService;
import com.example.kafka.domain.evento.EventoRepository;
import jdk.jfr.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;


@Component
public class DomainProducer {

    private final StreamBridge streamBridge;
    private final EventoService eventoService;
    private static final Logger LOGGER = LoggerFactory.getLogger(DomainProducer.class);

    @Autowired
    public DomainProducer(StreamBridge streamBridge, EventoService eventoService) {
        this.streamBridge = streamBridge;
        this.eventoService = eventoService;
    }

    public void sendMessage(DomainEvent evento) {
        String BINDING_NAME = "producer-out-0";
        String payload = evento.converterToJson();

        eventoService.salvar(payload);
        streamBridge.send(BINDING_NAME, payload);

        loggerInfoEventoEnviado(payload);
    }

    private void loggerInfoEventoEnviado(String payload) {
        LOGGER.info("### Evento enviado ###");
        LOGGER.info("Payload: " + payload);
    }


}
