package com.demo.slk.design.objectpool;

public class ObjectPoolDemo {

	public static void main(String[] str){
		ObjectPool objectPool = new JdbcConnection();
		objectPool.setDriver("sql driver");
		objectPool.setUrl("sql connection string");
		objectPool.setUserName("sohan");
		objectPool.setPassword("password");
		objectPool.setup();
		Connection connection=objectPool.getConnection();
		connection.save("Save sql query");
		System.out.println("** Connection object ** ");
		
	}
	
}
