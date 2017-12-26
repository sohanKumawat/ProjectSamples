package com.demo.slk.design.objectpool;

public class Connection {
	private String connectionString;

	public void save(String sql) {
		System.out.println("Save Data to database");
	}

	public void update(String sql) {
		System.out.println("Update data to sql");
	}

	public void findAll(String sql) {
		System.out.println("find all the record");
	}

	public String connectionUrl() {
		return connectionString;
	}

	public Connection(String connectionString) {
		this.connectionString = connectionString;
	}
}
