package com.example.amq_consumer.route;


import com.example.amq_consumer.model.Person;
import com.example.amq_consumer.model.Response;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import static net.bytebuddy.implementation.MethodDelegation.to;

@Component
public class ConsumerRoute extends RouteBuilder{

    @Override
    public void configure() {
        from("jms:queue:person")
                .routeId("consumer-route")
                .unmarshal().json(JsonLibrary.Jackson, Person.class)
                .log("Received payload: ${body.name}")
                .to("direct:hello");
    }
}
