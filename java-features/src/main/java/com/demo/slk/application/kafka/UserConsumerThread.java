package com.demo.slk.application.kafka;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class UserConsumerThread implements Runnable {

	  private final KafkaConsumer<String, User> consumer;
	  private final String topic;

	  public UserConsumerThread(String brokers, String groupId, String topic) {
	    Properties prop = createConsumerConfig(brokers, groupId);
	    this.consumer = new KafkaConsumer<>(prop);
	    this.topic = topic;
	    this.consumer.subscribe(Arrays.asList(this.topic));
	  }

	  private static Properties createConsumerConfig(String brokers, String groupId) {
	    Properties props = new Properties();
	    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers);
	    props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
	    props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "1000");
	    props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
	    props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
	    props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
	    props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
	    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
	    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "com.demo.slk.application.kafka.UserDeserializer");
	    return props;
	  }

	  @Override
	  public void run() {
	    while (true) {
	      ConsumerRecords<String, User> records = consumer.poll(100);
	      for (final ConsumerRecord<String, User> record : records) {
	        System.out.println("Receive: " + record.value().toString());
	      }
	    }
	  }
}
