package com.example.exercise2_amq.controller;

import com.example.exercise2_amq.model.Person;
import com.example.exercise2_amq.model.Response;
import org.apache.camel.ProducerTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class AMQController {

    private final ProducerTemplate producerTemplate;

    public AMQController(ProducerTemplate producerTemplate) {
        this.producerTemplate = producerTemplate;
    }

    @PostMapping(path = "/api/hello")
    public Response hello(@RequestBody Person person) {
        return producerTemplate.requestBody("direct:hello", person, Response.class);
    }
}
