package com.example.kafka.application.compra;

import com.example.kafka.infrastructure.kafka.DomainProducer;
import com.example.kafka.controller.compra.CompraDto;
import com.example.kafka.domain.compra.Compra;
import com.example.kafka.domain.compra.CompraEvento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CompraService {

    @Autowired
    private DomainProducer kafkaDomainProducer;

    public void comprar(CompraDto dto) {
        Compra compra = Compra.from(dto.getDescricao(), dto.getValor());

        CompraEvento evento = CompraEvento.from(compra);

        kafkaDomainProducer.sendMessage(evento);
    }
}
