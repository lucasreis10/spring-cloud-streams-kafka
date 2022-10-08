package com.example.kafka.domain.compra;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class Compra {
    @Id
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

    @Override
    public String toString() {
        return "Compra{" +
                "id='" + id + '\'' +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                '}';
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
