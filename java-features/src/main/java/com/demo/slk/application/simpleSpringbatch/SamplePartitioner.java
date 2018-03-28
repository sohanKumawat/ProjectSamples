package com.demo.slk.application.simpleSpringbatch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SamplePartitioner implements Partitioner {

	List<String> fileNameList = Arrays.asList("customer-data-1.csv", "customer-data-2.csv", "customer-data-3.csv",
			"customer-data-4.csv", "customer-data-5.csv");

	@Override
	public Map<String, ExecutionContext> partition(int gridSize) {
		Map<String, ExecutionContext> partitionData = new HashMap<String, ExecutionContext>();

		//
		// In the tutorial: gridSize = 5 for 5 Threads to read 5 files in
		// fileNameList:
		// {"customer-data-1.csv", "customer-data-2.csv", "customer-data-3.csv",
		// "customer-data-4.csv", "customer-data-5.csv"}
		//

		for (int i = 0; i < gridSize; i++) {
			ExecutionContext executionContext = new ExecutionContext();
			log.info("Starting : Thread" + i);
			log.info("File Name: " + fileNameList.get(i));

			// give fileName for ExecutionContext
			executionContext.putString("filename", fileNameList.get(i));
			// give a thread name for ExecutionContext
			executionContext.putString("name", "Thread" + i);

			partitionData.put("partition: " + i, executionContext);
		}

		return partitionData;
	}

}
