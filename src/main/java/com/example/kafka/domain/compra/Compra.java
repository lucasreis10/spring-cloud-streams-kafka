package com.example.kafka.domain.compra;

import java.util.UUID;

public class Compra {

    private String id;
    private String descricao;
    private Float valor;


    private Compra(String id, String descricao, Float valor) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
    }

    public static Compra from(String descricao, Float valor) {
        var id = UUID.randomUUID().toString().toLowerCase();

        return new Compra(id, descricao, valor);
    }

    public String getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Float getValor() {
        return valor;
    }
}
