package com.example.exercise2_amq.controller;

import com.example.exercise2_amq.model.Person;
import com.example.exercise2_amq.model.Response;
import org.apache.camel.ProducerTemplate;
import org.springframework.web.bind.annotation.*;

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
