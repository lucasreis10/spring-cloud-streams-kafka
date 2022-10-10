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

    private final DomainProducer domainProducer;
    private final CompraRepository compraRepository;

    @Autowired
    public CompraService(DomainProducer domainProducer, CompraRepository compraRepository) {
        this.domainProducer = domainProducer;
        this.compraRepository = compraRepository;
    }

    public CompraDto comprar(CompraDto dto) {
        Compra compra = Compra.from(dto.getDescricao(), dto.getValor());
        CompraEvento evento = CompraEvento.from(compra);

        // TODO implementar pattern transactional outbox
        compraRepository.save(compra);
        domainProducer.sendMessage(evento);

        return new CompraDto(compra);
    }

    public List<CompraDto> listarCompras() {
        List<Compra> compras = compraRepository.findAll();

        return compras.stream().map(CompraDto::new).collect(Collectors.toList());
    }
}
