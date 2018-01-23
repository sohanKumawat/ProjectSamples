package com.demo.slk.application.apachecamel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.slk.application.apachecamel.filter.EntityFilter;
import com.demo.slk.application.apachecamel.logger.EntityLogger;
import com.demo.slk.application.apachecamel.processor.EntityProcessor;
import com.demo.slk.application.apachecamel.transformation.EntityTransformater;

@Component
public class FrontRouteConfiguratioin extends RouteBuilder {
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
		from("direct:integration-route").filter(entityFilter).process(processor).process(processor).transform(transform).choice()
	    .when(header("foo").isEqualTo("bar"))
		.to("direct:d").when(header("foo").isEqualTo("cheese")).to("direct:b")
		.otherwise().process(processor).transform(transform).to("direct:c")
		.log("Camel body: ${body}");		
	}
}