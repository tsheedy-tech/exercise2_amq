package com.example.amq_producer.controller;

import com.example.amq_producer.model.Person;
import com.example.amq_producer.model.Response;
import org.apache.camel.ProducerTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    private final ProducerTemplate producerTemplate;

    public ProducerController(ProducerTemplate producerTemplate) {
        this.producerTemplate = producerTemplate;
    }

    @PostMapping(path = "/api/hello")
    public Response hello(@RequestBody Person person) {
        producerTemplate.sendBody("direct:hello", person);

        return new Response(person.getName());
    }
}
