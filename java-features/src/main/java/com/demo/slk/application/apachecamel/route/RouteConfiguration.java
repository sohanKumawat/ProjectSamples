package com.demo.slk.application.apachecamel.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.demo.slk.application.apachecamel.filter.EntityFilter;
import com.demo.slk.application.apachecamel.logger.EntityLogger;
import com.demo.slk.application.apachecamel.processor.EntityProcessor;
import com.demo.slk.application.apachecamel.transformation.EntityTransformater;

@Component
public class RouteConfiguration extends RouteBuilder {

	@Autowired
	EntityFilter entityFilter;
	@Autowired
	EntityLogger logger;
	@Autowired
	EntityProcessor processor;
	@Autowired
	EntityTransformater transform;
	 @Value("${server.port}")
	    String serverPort;
	    
	    @Value("${baeldung.api.path}")
	    String contextPath;
	@Override
	public void configure() throws Exception {
		errorHandler(deadLetterChannel("mock:error"));
//		restConfiguration().host("localhost").port("8080").enableCORS(true);
		
		 restConfiguration().contextPath(contextPath) //
         .port(serverPort)
         .enableCORS(true)
         .apiContextPath("/api-doc")
         .apiProperty("api.title", "Test REST API")
         .apiProperty("api.version", "v1")
         .apiProperty("cors", "true") // cross-site
         .apiContextRouteId("doc-api")
         .component("servlet")
         .bindingMode(RestBindingMode.json)
         .dataFormatProperty("prettyPrint", "true");
		
		
		
		from("direct:b").tracing().choice()
		        .when(header("foo").isEqualTo("bar")).process(processor).transform(transform)
				.to("direct:b").when(header("foo").isEqualTo("cheese")).to("direct:b")
				.otherwise().process(processor).transform(transform).to("direct:b")
				.log("Camel body: ${body}");
		rest("/say")
        .get("/hello").consumes("application/json").to("direct:b")
        .get("/bye").consumes("application/json").to("direct:bye")
        .post("/bye").to("mock:update");
	//	from("http://localhost:8080/hello").to("direct:b");
	}

}
