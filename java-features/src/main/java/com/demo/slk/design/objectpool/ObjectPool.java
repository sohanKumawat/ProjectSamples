package com.demo.slk.design.objectpool;

public abstract class ObjectPool {
	private String driver;
	private String url;
	private String userName;
	private String password;
	private int maxConnection;
	private int minConnection;
	
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMaxConnection() {
		return maxConnection;
	}
	public void setMaxConnection(int maxConnection) {
		this.maxConnection = maxConnection;
	}
	public int getMinConnection() {
		return minConnection;
	}
	public void setMinConnection(int minConnection) {
		this.minConnection = minConnection;
	}
	abstract public void setup();
	abstract public void execute();
	abstract public Connection getConnection();
	abstract public void releaseConnection(Connection conn);
}
