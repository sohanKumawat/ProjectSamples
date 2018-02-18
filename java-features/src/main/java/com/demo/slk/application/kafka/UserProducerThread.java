package com.demo.slk.application.kafka;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

//http://cloudurable.com/blog/kafka-architecture-low-level/index.html
public class UserProducerThread implements Runnable {

	private final KafkaProducer<String, User> producer;
	private final String topic;

	public UserProducerThread(String brokers, String topic) {
		Properties prop = createProducerConfig(brokers);
		this.producer = new KafkaProducer<String, User>(prop);
		this.topic = topic;
	}

	private static Properties createProducerConfig(String brokers) {
		Properties props = new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers);
		props.put(ProducerConfig.ACKS_CONFIG, "all");
		props.put(ProducerConfig.RETRIES_CONFIG, 0);
		props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
		props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
		props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
				"org.apache.kafka.common.serialization.StringSerializer");
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "com.demo.slk.application.kafka.UserSerializer");
		 props.put(ProducerConfig.PARTITIONER_CLASS_CONFIG,
			        "com.demo.slk.application.kafka.UserPatitioner");

		return props;
	}

	@Override
	public void run() {
		List<User> users = new ArrayList<>();
		users.add(new User(1l, "tom", "Tom", "Riddle", 40));
		users.add(new User(2l, "harry", "Harry", "Potter", 10));
		for (User user : users) {
			producer.send(new ProducerRecord<String, User>(topic, user.getUserName(), user), new Callback() {
				public void onCompletion(RecordMetadata metadata, Exception e) {
					if (e != null) {
						e.printStackTrace();
					}
					System.out.println("Sent:" + user.toString());
				}
			});
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		// closes producer
		producer.close();

	}
}