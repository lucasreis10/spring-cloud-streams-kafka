package com.example.kafka.application.compra;

import com.example.kafka.domain.compra.CompraRepository;
import com.example.kafka.infrastructure.kafka.DomainProducer;
import com.example.kafka.controller.compra.CompraDto;
import com.example.kafka.domain.compra.Compra;
import com.example.kafka.domain.compra.CompraEvento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CompraService {

    private DomainProducer domainProducer;
    private CompraRepository compraRepository;

    @Autowired
    public CompraService(DomainProducer domainProducer, CompraRepository compraRepository) {
        this.domainProducer = domainProducer;
        this.compraRepository = compraRepository;
    }

    public void comprar(CompraDto dto) {
        Compra compra = Compra.from(dto.getDescricao(), dto.getValor());

        compraRepository.save(compra);

        CompraEvento evento = CompraEvento.from(compra);
        domainProducer.sendMessage(evento);
    }

    public List<CompraDto> listarCompras() {
        List<Compra> compras = compraRepository.findAll();

        return compras.stream().map(CompraDto::new).collect(Collectors.toList());
    }
}
