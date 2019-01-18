package com.mb.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.demo.beans.CustomerProfile;

@Service
public class CustomerProfileService {

	@Autowired
	CustomerProfile customerProfile;

	public CustomerProfile getCustomerProfile() {
		return customerProfile;
	}

	public long getCustomerId() {
		return customerProfile.getCustomerId();
	}

	public long getClusterId() {
		return customerProfile.getClusterId();
	}

	public long getHubId() {
		return customerProfile.getHubId();
	}

	public long getTowerId() {
		return customerProfile.getTowerId();
	}

	public long getSocietyId() {
		return customerProfile.getSocietyId();
	}

}
