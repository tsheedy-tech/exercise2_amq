package com.example.amq_producer.route;


import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class ProducerRoute extends RouteBuilder{

    @Override
    public void configure() {
        from("direct:hello")
                .routeId("producer-route")
                .marshal().json(JsonLibrary.Jackson)
                .to("jms:queue:person");
    }
}
