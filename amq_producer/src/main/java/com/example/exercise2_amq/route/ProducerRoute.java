package com.example.exercise2_amq.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ProducerRoute extends RouteBuilder{

    @Override
    public void configure() {
        from("direct:hello")
                .routeId("producer-route")
                .to("jms:queue:person");
    }
}
