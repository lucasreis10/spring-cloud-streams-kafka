package com.example.kafka.application.evento;

import com.example.kafka.domain.evento.Evento;
import com.example.kafka.domain.evento.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;

    @Autowired
    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public void salvar(String payload) {
        var evento = Evento.from(payload);

        eventoRepository.save(evento);
    }
}
