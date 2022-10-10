package com.example.kafka.controller.compra;

import com.example.kafka.domain.compra.Compra;

public class CompraDto {

    private String descricao;
    private Float valor;

    public CompraDto(String id, String descricao, Float valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public CompraDto(Compra compra) {
        this.descricao = compra.getDescricao();
        this.valor = compra.getValor();
    }


    public String getDescricao() {
        return descricao;
    }

    public Float getValor() {
        return valor;
    }
}
