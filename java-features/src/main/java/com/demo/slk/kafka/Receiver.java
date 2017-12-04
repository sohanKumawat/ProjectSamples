package com.demo.slk.kafka;

import java.util.concurrent.CountDownLatch;

import org.springframework.kafka.annotation.KafkaListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Receiver {
	private CountDownLatch latch = new CountDownLatch(1);

	  public CountDownLatch getLatch() {
	    return latch;
	  }

	  @KafkaListener(topics = "${kafka.topic.helloworld}")
	  public void receive(String payload) {
	    log.info("received payload='{}'", payload);
	    latch.countDown();
	  }
	  
	 /* @KafkaListener(
			  topicPartitions = @TopicPartition(topic = "topicName",
			  partitionOffsets = {
			    @PartitionOffset(partition = "0", initialOffset = "0"), 
			    @PartitionOffset(partition = "3", initialOffset = "0")
			}))
			public void listenToParition(
			  @Payload String message, 
			  @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
			      System.out.println(
			        "Received Messasge: " + message"
			        + "from partition: " + partition);
			}*/
}
