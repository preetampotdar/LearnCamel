package com.learncamel.routes.process;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifyDirectProcessorRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifyDirectProcessorRoute();
    }

    @Test
    public void processorDirectTest() {
        String expected="123:Dilip:12JAN2017";
        String input="123,Dilip,12JAN2017";
        String output = (String) template.requestBody("direct:process", input);
        assertEquals(expected, output);
    }

    @Test
    public void processorDirectUsingMock() throws InterruptedException {
        String expected = "123:Dilip:12JAN2017";
        MockEndpoint mockEndpoint = getMockEndpoint("mock:output");
        mockEndpoint.expectedBodiesReceived(expected);
        String input="123,Dilip,12JAN2017";
        template.sendBody("direct:process",input);
        assertMockEndpointsSatisfied();

    }
}
