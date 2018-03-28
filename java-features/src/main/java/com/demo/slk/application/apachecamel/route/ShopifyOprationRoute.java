package com.demo.slk.application.apachecamel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.slk.application.apachecamel.filter.EntityFilter;
import com.demo.slk.application.apachecamel.logger.EntityLogger;
import com.demo.slk.application.apachecamel.processor.EntityProcessor;
import com.demo.slk.application.apachecamel.transformation.EntityTransformater;

@Component
public class ShopifyOprationRoute extends RouteBuilder {

	@Autowired
	EntityFilter entityFilter;
	@Autowired
	EntityLogger logger;
	@Autowired
	EntityProcessor processor;
	@Autowired
	EntityTransformater transform;
	
  //ShopifyProcessor processor;
	
	@Override
	public void configure() throws Exception {
		
		from("direct:shopify-order-status").filter(entityFilter).process(processor).process(processor).transform(transform).choice()
	  // .when(header("taskName").isEqualTo("order_status")).process(processor.getOrderProcessor,"oderStatus")
	  // .when(header("taskName").isEqualTo("order_tracker")).process(processor.getOrderProcessor,"orderTracker")
		 .to("direct:d").when(header("foo").isEqualTo("cheese")).to("direct:b")
		 .otherwise().process(processor).transform(transform).to("direct:c")
		 .log("Camel body: ${body}");
		
	}

}
