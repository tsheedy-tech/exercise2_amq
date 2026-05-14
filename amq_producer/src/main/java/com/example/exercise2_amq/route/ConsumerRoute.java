package com.example.exercise2_amq.route;

import com.example.exercise2_amq.model.Person;
import com.example.exercise2_amq.model.Response;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ConsumerRoute extends RouteBuilder{

    @Override
    public void configure() {
        from("jms:queue:person")
                .routeId("consumer-route")
                .process(exchange -> {
                    Person person = exchange.getIn().getBody(Person.class);
                    exchange.getIn().setBody(new Response(person.getName()));
                })
                .log("Hello ${body.hello}");
    }
}
