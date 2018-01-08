package com.demo.slk.apachecamel.transformation;

import org.apache.camel.Exchange;
import org.apache.camel.Expression;
import org.apache.camel.Message;
import org.apache.camel.TypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntityTransformater implements Expression {
	@Autowired
	private TypeConverter typeConverter;

	public long parseInvoiceValue(String meassge) {
		return typeConverter.convertTo(Long.class, meassge);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T evaluate(Exchange exchange, Class<T> type) {
		Message message=(Message) exchange.getIn().getBody();
		System.out.println("Inside the process of apache camel"+message.toString());
		return (T) message.getMessageId();
	}
}
