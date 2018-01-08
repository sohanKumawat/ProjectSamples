package com.demo.slk.apachecamel.filter;

import org.apache.camel.Exchange;
import org.apache.camel.Predicate;

public class EntityPrediction implements Predicate {
	@Override
	public boolean matches(Exchange exchange) {
		 final String body = exchange.getIn().getBody(String.class);
         return ((body != null) && body.startsWith("Camel"));
	}

}
