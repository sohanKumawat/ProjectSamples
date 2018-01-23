package com.demo.slk.application.apachecamel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.slk.application.apachecamel.filter.EntityFilter;
import com.demo.slk.application.apachecamel.logger.EntityLogger;
import com.demo.slk.application.apachecamel.processor.EntityProcessor;
import com.demo.slk.application.apachecamel.transformation.EntityTransformater;

@Component
public class ShopifyRoute  extends RouteBuilder {
	@Autowired
	EntityFilter entityFilter;
	@Autowired
	EntityLogger logger;
	@Autowired
	EntityProcessor processor;
	@Autowired
	EntityTransformater transform;
	@Override
	public void configure() throws Exception {
		from("direct:shopify-route").filter(entityFilter).process(processor).process(processor).transform(transform)
		.to("direct:"+header("route"))//header("route") --> shopify_order_status
		.log("Camel body: ${body}");
		
	}

}
