package ai.msg.training.portal.common.utils;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQPublisher<T> {
	private static transient Logger LOGGER = LoggerFactory.getLogger(RabbitMQPublisher.class);
     @Autowired
	private RabbitTemplate rabbitTemplate;

    private DirectExchange directMessageExchange = DirectExchange.DEFAULT;

	public void publish(String routingKey, T payload) {
		LOGGER.debug("message publisher ***** at {} payload : ", System.currentTimeMillis(), payload.toString());
		this.rabbitTemplate.convertAndSend(directMessageExchange.getName(), routingKey, payload);
	}

	public void publish(String routingKey, List<T> payloadList) {
		for(T payload : payloadList) {
			publish(routingKey, payload);
		}
	}

	public static Object convert(Message message, Class expectedType) {
		return RabbitMQConfigHelper.jsonMessageConverter(expectedType).fromMessage(message);
	}
}
