package com.example.exercise2_amq.route;

import com.example.exercise2_amq.model.Person;
import com.example.exercise2_amq.model.Response;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class AMQRoute extends RouteBuilder {

    @Override
    public void configure() {
        from("direct:hello")
        .setBody(exchange -> {
            Person person = exchange.getIn().getBody(Person.class);
            return new Response(person.getName());
        });
    }
}
