package com.example.exercise2_amq.route;

import com.example.exercise2_amq.model.Person;
import com.example.exercise2_amq.model.Response;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ProducerRoute extends RouteBuilder{

    @Override
    public void configure() {
        from("direct:hello")
                .routeId("producer-route")
                .process(exchange -> {
                    Person person = exchange.getIn().getBody(Person.class);
                    exchange.getIn().setBody(new Response(person.getName()));
                })
                .to("jms:queue:person");
    }
}
