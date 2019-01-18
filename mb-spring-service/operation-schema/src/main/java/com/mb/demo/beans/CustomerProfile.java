package com.mb.demo.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
// @org.springframework.context.annotation.Scope(WebApplicationContext.SCOPE_SESSION)
public class CustomerProfile implements Serializable {

	private static final long serialVersionUID = 3989606472209800723L;

	private long customerId;
	private long hubId;
	private long clusterId;
	private long societyId;
	private long towerId;
	private String image;
	private String firstName;
	private String lastName;

	@PostConstruct
	public void init() {
		this.clusterId = 1;
		this.customerId = 1;
		this.hubId = 1;
		this.societyId = 1;
		this.towerId = 1;
		this.image = "sohan.jpg";
		this.firstName = "sohan";
		this.lastName = "kumawat";
	}

}
