package com.example.exercise2_amq.model;

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
