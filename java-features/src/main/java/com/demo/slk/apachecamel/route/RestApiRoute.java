package com.demo.slk.apachecamel.route;

import javax.ws.rs.core.MediaType;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.demo.slk.apachecamel.entity.Account;
import com.demo.slk.apachecamel.service.AccountService;

public class RestApiRoute extends RouteBuilder {
	@Value("${server.port}")
	String serverPort;

	@Value("${baeldung.api.path}")
	String contextPath;
	@Autowired
	AccountService accountService;

	@Override
	public void configure() {

		restConfiguration().contextPath(contextPath) //
				.port(serverPort).enableCORS(true).apiContextPath("/api-doc").apiProperty("api.title", "Test REST API")
				.apiProperty("api.version", "v1").apiProperty("cors", "true") // cross-site
				.apiContextRouteId("doc-api").component("servlet").bindingMode(RestBindingMode.json)
				.dataFormatProperty("prettyPrint", "true");
		/**
		 * The Rest DSL supports automatic binding json/xml contents to/from
		 * POJOs using Camels Data Format. By default the binding mode is off,
		 * meaning there is no automatic binding happening for incoming and
		 * outgoing messages. You may want to use binding if you develop POJOs
		 * that maps to your REST services request and response types.
		 */

		rest("/api/").description("Teste REST Service").id("api-route").post("/bean")
				.produces(MediaType.APPLICATION_JSON).consumes(MediaType.APPLICATION_JSON)
				// .get("/hello/{place}")
				.bindingMode(RestBindingMode.auto).type(Account.class).enableCORS(true)
				// .outType(OutBean.class)

				.to("direct:remoteService");
		from("direct:remoteService").routeId("direct-route").tracing().log(">>> ${body.id}").log(">>> ${body.name}")
				// .transform().simple("blue ${in.body.name}")
				.process(new Processor() {
					@Override
					public void process(Exchange exchange) throws Exception {
						Account bodyIn = (Account) exchange.getIn().getBody();
						accountService.example(bodyIn);
						exchange.getIn().setBody(bodyIn);
					}
				}).setHeader(Exchange.HTTP_RESPONSE_CODE, constant(201));
	}
}
