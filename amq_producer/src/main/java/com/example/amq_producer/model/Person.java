package com.example.amq_producer.model;

import lombok.Data;

@Data
public class Person {
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }
}
