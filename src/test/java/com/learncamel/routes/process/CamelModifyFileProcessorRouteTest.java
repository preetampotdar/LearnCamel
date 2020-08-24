package com.learncamel.routes.process;

import com.learncamel.routes.process.CamelModifyFileProcessorRoute;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class CamelModifyFileProcessorRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifyFileProcessorRoute();
    }

    @Test
    public void processorTest() throws InterruptedException {
        String expectedValue = "123:Dilip:12JAN2017\n" +
                "456:Adam:12JAN2017\n";

        MockEndpoint mockEndpoint = new MockEndpoint("mock:output");
        mockEndpoint.expectedBodiesReceived(expectedValue);
        Thread.sleep(5000);
        File file = new File("data/output");
        assertTrue(file.isDirectory());
        assertMockEndpointsSatisfied();
    }
}
