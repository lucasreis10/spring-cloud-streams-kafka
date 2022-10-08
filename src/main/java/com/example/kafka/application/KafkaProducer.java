package com.example.kafka.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class KafkaProducer {

    @Autowired
    private StreamBridge streamBridge;

    @Scheduled(cron = "*/3 * * * * *")
    public void sendMessage() {
        String BINDING_NAME = "producer-out-0";
        String message = "New message from bridge " +  Instant.now();
        streamBridge.send(BINDING_NAME, message);
    }

}
