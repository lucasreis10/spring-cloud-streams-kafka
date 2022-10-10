package com.example.kafka.domain;

import java.util.UUID;

public class DomainId {

    public static String gerarIUUID() {
        return UUID.randomUUID().toString().toLowerCase();
    }

}
