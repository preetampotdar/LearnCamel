package com.learncamel.direct;

import org.apache.camel.builder.RouteBuilder;

public class SampleDirectRoute extends RouteBuilder {
    public void configure() throws Exception {
        from("direct:sampleInput")
                .log("Received message body is ${body} and headers are ${headers}")
                .to("file:sampleOutput?fileName=output.txt");
    }
}
