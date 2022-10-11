package com.example.kafka.domain.evento;

import com.example.kafka.domain.DomainId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document
public class Evento {

    @Id
    private final String id;
    private final String payload;
    private final Instant dataEvento;


    private Evento(String id, String payload, Instant dataEvento) {
        this.id = id;
        this.payload = payload;
        this.dataEvento = dataEvento;
    }

    public static Evento newEvento(String payload) {
        var id = DomainId.gerarIUUID();
        var now = Instant.now();

        return new Evento(id, payload, now);
    }

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

    public Instant getDataEvento() {
        return dataEvento;
    }
}
