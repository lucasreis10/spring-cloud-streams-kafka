package com.example.kafka.domain.evento;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends MongoRepository<Evento, String> {
}
