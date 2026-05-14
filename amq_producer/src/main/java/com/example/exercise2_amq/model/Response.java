package com.example.exercise2_amq.model;

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
