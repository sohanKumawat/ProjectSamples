package com.demo.slk.design.objectpool;

public class ConnectionProperties {
	private String driver;
	private String url;
	private String userName;
	private String password;
	public String getDriver() {
		return driver;
	}
	public ConnectionProperties setDriver(String driver) {
		this.driver = driver;
		return this;
	}
	public String getUrl() {
		return url;
	}
	public ConnectionProperties setUrl(String url) {
		this.url = url;
		return this;
	}
	public String getUserName() {
		return userName;
	}
	public ConnectionProperties setUserName(String userName) {
		this.userName = userName;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public ConnectionProperties setPassword(String password) {
		this.password = password;
		return this;
	}
	
}
