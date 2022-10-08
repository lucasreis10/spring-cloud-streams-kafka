package com.example.kafka.domain.evento;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Evento {

    @Id
    private String id;
    private String payload;


    @Override
    public String toString() {
        return "Evento{" +
                "id='" + id + '\'' +
                ", payload='" + payload + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getPayload() {
        return payload;
    }
}
