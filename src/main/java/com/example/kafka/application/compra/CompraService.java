package com.example.kafka.application.compra;

import com.example.kafka.application.KafkaProducer;
import com.example.kafka.controller.compra.CompraDto;
import com.example.kafka.domain.compra.Compra;
import com.example.kafka.domain.compra.CompraEvento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CompraService {

    @Autowired
    private KafkaProducer kafkaProducer;

    public void comprar(CompraDto dto) {
        Compra compra = Compra.from(dto.getDescricao(), dto.getValor());

        CompraEvento evento = CompraEvento.from(compra);

        kafkaProducer.sendMessage(evento);
    }
}
