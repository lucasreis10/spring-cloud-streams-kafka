package com.example.kafka.domain.compra;

import com.example.kafka.domain.DomainId;
import com.example.kafka.domain.produto.Produto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Document
public class Compra {
    @Id
    private final String id;
    private final String descricao;
    private final Float valor;
    private final Instant data;
    @DBRef
    private final List<Produto> produtos;


    private Compra(String id, String descricao, Float valor, Instant data, List<Produto> produtos) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.produtos = produtos;
    }

    public static Compra newCompra(String descricao, Float valor) {
        var id = DomainId.gerarIUUID();
        var now = Instant.now();

        return new Compra(id, descricao, valor, now, List.of());
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

    public Instant getData() {
        return data;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
