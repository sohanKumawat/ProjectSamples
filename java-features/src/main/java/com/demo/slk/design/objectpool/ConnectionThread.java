package com.demo.slk.design.objectpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class ConnectionThread {
	private static List<ConnectionObject> connObj = new ArrayList<>();
	private static CountDownLatch threadCount;

	public static class ConnectionObject implements Callable<Connection> {
		@Override
		public Connection call() throws Exception {
			String connectionString = cProperties.getDriver() + "#" + cProperties.getUrl() + "#"
					+ cProperties.getUserName() + "#" + cProperties.getPassword();
			Connection connetion = new Connection(connectionString);
			return connetion;
		}
		ConnectionProperties cProperties;
		public ConnectionObject(ConnectionProperties cProperties) {
			this.cProperties = cProperties;
		}
	}

	public static void addTask(ConnectionObject cObj) {
		connObj.add(cObj);
	}
	public static List<Connection> getConnections(int noConnection,ConnectionProperties properties){
		 for(int i=0;i<noConnection;i++){
			 ConnectionThread.addTask(new ConnectionObject(properties));
		 }
		return createConnection();
	}

	public static List<Connection> createConnection() {
		 List<Connection> connections = new ArrayList<>();
		threadCount = new CountDownLatch(connObj.size());
		for (ConnectionObject cObj : connObj) {
			ListenableFuture<Connection> future = AsyncTaskExecutors.getTaskExecutor().submitListenable(cObj);
			future.addCallback(new ListenableFutureCallback<Connection>() {
				@Override
				public void onSuccess(Connection connection) {
					connections.add(connection);
					threadCount.countDown();
				}
				@Override
				public void onFailure(Throwable ex) {
					log.error("Failed to execute", ex);
					threadCount.countDown();
				}
			});
		}
		try {
			threadCount.await();
		} catch (InterruptedException ie) {
			log.error("CountDownLatch was interrupted " + threadCount, ie);
			ie.printStackTrace();
		}
		return connections;
	}

}
