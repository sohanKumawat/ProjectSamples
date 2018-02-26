package com.demo.slk.application.kafka;

public class KakfaCustomSerializerMain {

	public static void main(String[] args) {

		String brokers = "localhost:9092;localhost:9093;localhost:9094";
		String groupId = "group01";
		String topic = "UserMessageTopic10";

		if (args != null && args.length == 3) {
			brokers = args[0];
			groupId = args[1];
			topic = args[2];
		}
		// Start User Producer Thread
		UserProducerThread producerThread = new UserProducerThread(brokers, topic);
		Thread t1 = new Thread(producerThread);
		t1.start();
		// Start group of User Consumer Thread
		UserConsumerThread consumerThread = new UserConsumerThread(brokers, groupId, topic);
		Thread t2 = new Thread(consumerThread);
		t2.start();
		try {
			Thread.sleep(100000);
		} catch (InterruptedException ie) {

		}
	}
}
