package com.example.kafka.application.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

public class MessageSerializer implements Serializer<String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String topic, String data) {
       try {
           return objectMapper.writeValueAsBytes(data);
       } catch (JsonProcessingException e) {
           throw new SerializationException(e);
       }

    }
}
