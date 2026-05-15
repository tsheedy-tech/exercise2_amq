package com.example.amq_producer.route;

import com.example.amq_producer.model.Person;
import com.example.amq_producer.model.Response;
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
