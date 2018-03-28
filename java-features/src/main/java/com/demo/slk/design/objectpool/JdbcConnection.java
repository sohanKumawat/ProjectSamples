package com.demo.slk.design.objectpool;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class JdbcConnection extends ObjectPool {

	private ConcurrentLinkedQueue<Connection> connectionQueue = new ConcurrentLinkedQueue<>();
	ConnectionProperties properties;

	@Override
	public void execute() {
		List<Connection> connections = ConnectionThread.getConnections(this.getMinConnection(), properties);
		connectionQueue.addAll(connections);
	}

	@Override
	public Connection getConnection() {
		if (connectionQueue.size() > 0)
			return connectionQueue.poll();
		else {
			List<Connection> connections = ConnectionThread.getConnections(1, properties);
			return connections.get(0);
		}
	}

	@Override
	public void releaseConnection(Connection conn) {
     if(connectionQueue.size()<this.getMinConnection()) connectionQueue.add(conn);
	}

	@Override
	public void setup() {
		properties = new ConnectionProperties();
		properties.setDriver(this.getDriver()).setPassword(this.getPassword()).setUrl(this.getUrl())
				.setUserName(this.getUserName());
		execute();
	}

}