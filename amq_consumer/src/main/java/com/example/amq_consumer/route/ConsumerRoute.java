package com.example.amq_consumer.route;

import com.example.amq_consumer.model.Person;
import com.example.amq_consumer.model.Response;
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
                .log("Log: ${body.hello}");
    }
}
