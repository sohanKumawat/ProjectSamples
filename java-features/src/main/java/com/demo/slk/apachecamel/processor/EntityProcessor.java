package com.demo.slk.apachecamel.processor;

import org.apache.camel.ConsumerTemplate;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class EntityProcessor implements Processor {
	@Autowired
	private ProducerTemplate producerTemplate;
	@Autowired
	private ConsumerTemplate consumerTemplate;
	public void processNextInvoice() {
	    String message = consumerTemplate.receiveBody("direct:b", String.class);
	    /*
	     * Implement all your business logics here
	     * 
	     * */
	    producerTemplate.sendBody("http://localhost:8080/received/" +message);
	  }
	@Override
	public void process(Exchange exchange) throws Exception {
		Message message=(Message) exchange.getIn().getBody();
		System.out.println("Inside the process of apache camel"+message.toString());
	}
}
