package com.example.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.Instant;
import java.util.function.Consumer;
import java.util.function.Supplier;

@SpringBootApplication
@EnableScheduling
public class KafkaStreams {

	public static void main(String[] args) {
		SpringApplication.run(KafkaStreams.class, args);
	}

	@Bean
	public Supplier<String> producer() {
		var message = "New message from streams " + Instant.now();
		return () -> message;
	}

	@Bean
	public Consumer<String> consumer() {
		return message -> System.out.println("recevid " + message);
	}

}



