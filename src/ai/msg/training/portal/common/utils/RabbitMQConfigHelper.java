package ai.msg.training.portal.common.utils;

import java.net.URI;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;

import com.typesafe.config.Config;

public class RabbitMQConfigHelper {
	public static final String AMQP_URL = "rabbitmq.url";
	public static final String ROUTING_KEY = "rabbitmq.routingKey";
	public static final String QUEUE_NAME = "rabbitmq.queueName";

	protected Config config = null;

    public RabbitMQConfigHelper(Config config) {
    	this.config = config;
    }

    public ConnectionFactory connectionFactory() throws Exception {
    	return connectionFactory(this.config.getString(AMQP_URL));
    }

    public static ConnectionFactory connectionFactory(String url) throws Exception {
        final URI ampqUrl = new URI(url);

        final CachingConnectionFactory factory = new CachingConnectionFactory();
        factory.setUsername(ampqUrl.getUserInfo().split(":")[0]);
        factory.setPassword(ampqUrl.getUserInfo().split(":")[1]);
        factory.setHost(ampqUrl.getHost());
        factory.setPort(ampqUrl.getPort());
        factory.setVirtualHost(ampqUrl.getPath().substring(1));

        return factory;
    }

    public AmqpAdmin amqpAdmin() throws Exception {
        return new RabbitAdmin(connectionFactory());
    }

    public RabbitTemplate rabbitTemplate() throws Exception {
    	return rabbitTemplate(this.config.getString(AMQP_URL), 
    			this.config.getString(ROUTING_KEY), 
    			this.config.getString(QUEUE_NAME), jsonMessageConverter());
    }

    public static RabbitTemplate rabbitTemplate(String amqpUrl, String routingKey, 
    		String queueName, MessageConverter messageConverter) throws Exception {
        RabbitTemplate template = new RabbitTemplate(connectionFactory(amqpUrl));
        template.setRoutingKey(routingKey);
        template.setQueue(queueName);
        template.setMessageConverter(messageConverter);
        return template;
    }

    public SimpleMessageListenerContainer messageListenerContainer(
    		MessageListenerAdapter messageListenerAdapter) throws Exception {
    	return messageListenerContainer(this.config.getString(AMQP_URL), 
    			this.config.getString(QUEUE_NAME), jsonMessageConverter(), messageListenerAdapter);
	}

    public static SimpleMessageListenerContainer messageListenerContainer(String amqpUrl, 
    		String queueName, MessageConverter messageConverter, 
    		MessageListenerAdapter messageListenerAdapter) throws Exception {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();

		container.setConnectionFactory(connectionFactory(amqpUrl));
		container.setQueues(queue(queueName));
		container.setMessageListener(messageListenerAdapter);

		return container;
	}

    public static Queue queue(String queueName) {
        return new Queue(queueName);
    }

    public static MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    public static <T> MessageConverter jsonMessageConverter(Class<T> clazz) {
    	Jackson2JsonMessageConverter msgConverter = new Jackson2JsonMessageConverter();

    	DefaultClassMapper clazzMapper = new DefaultClassMapper();
    	clazzMapper.setDefaultType(clazz);

    	msgConverter.setClassMapper(clazzMapper);

    	return msgConverter;
    }
}
