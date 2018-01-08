package com.demo.slk.apachecamel.filter;

import org.apache.camel.Exchange;
import org.apache.camel.model.language.ExpressionDefinition;
import org.springframework.stereotype.Component;
@Component
public class EntityFilter extends ExpressionDefinition{

	@Override
	public <T> T evaluate(Exchange arg0, Class<T> arg1) {
		return null;
	}

}
