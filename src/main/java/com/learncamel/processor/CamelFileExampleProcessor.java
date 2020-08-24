package com.learncamel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.component.file.GenericFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CamelFileExampleProcessor implements org.apache.camel.Processor {
    public void process(Exchange exchange) throws Exception {
        System.out.println("Exchange in the processor is "+exchange.getIn().getBody());
        GenericFile<File> genericFile = (GenericFile<File>) exchange.getIn().getBody();

        String readLine = null;
        String newValue = "";
        if(genericFile!=null) {
            FileReader fileReader= new FileReader(genericFile.getFile());
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((readLine = bufferedReader.readLine())!=null) {
                System.out.println("Read line is "+readLine);
                String oldValue = readLine;
                newValue = newValue.concat(oldValue.replace(",", ":")).concat("\n");
                exchange.getIn().setBody(newValue);
            }
        }
    }
}
