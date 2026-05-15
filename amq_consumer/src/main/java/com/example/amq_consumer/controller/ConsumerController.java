package com.example.amq_consumer.controller;

import com.example.amq_consumer.model.Person;
import com.example.amq_consumer.model.Response;
import org.apache.camel.ProducerTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    private final ProducerTemplate producerTemplate;

    public ConsumerController(ProducerTemplate producerTemplate) {
        this.producerTemplate = producerTemplate;
    }
}
