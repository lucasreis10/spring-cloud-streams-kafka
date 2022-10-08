package com.example.kafka.domain.compra;

import com.example.kafka.infrastructure.kafka.DomainEvent;

public class CompraEvento extends DomainEvent {

    private String id;
    private String descricao;
    private Float valor;


    private CompraEvento(String id, String descricao, Float valor) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
    }

    public static CompraEvento from(Compra compra) {
        return new CompraEvento(compra.getId(), compra.getDescricao(), compra.getValor());
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
