package com.example.amq_consumer.model;

import lombok.Data;

@Data
public class Response {
    private String hello;

    public Response() {
    }

    public Response(String hello) {
        this.hello = hello;
    }
}
