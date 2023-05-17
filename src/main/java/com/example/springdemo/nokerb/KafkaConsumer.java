package com.example.springdemo.nokerb;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KafkaConsumer {
    @KafkaListener(topics = "my-topic", groupId = "my-group")
    public void consume(List<String> messages) {
        System.out.println("Received Message: " + messages);
    }
}