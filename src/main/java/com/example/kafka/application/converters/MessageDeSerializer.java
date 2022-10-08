package com.example.kafka.application.converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class MessageDeSerializer implements Deserializer<String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(new String(data), String.class);
        } catch (IOException e) {
            throw new SerializationException(e);
        }    }
}
