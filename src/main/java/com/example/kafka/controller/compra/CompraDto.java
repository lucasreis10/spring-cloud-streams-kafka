package com.example.kafka.controller.compra;

public class CompraDto {

    private String descricao;
    private Float valor;

    public CompraDto(String id, String descricao, Float valor) {
        this.descricao = descricao;
        this.valor = valor;
    }


    public String getDescricao() {
        return descricao;
    }

    public Float getValor() {
        return valor;
    }
}
