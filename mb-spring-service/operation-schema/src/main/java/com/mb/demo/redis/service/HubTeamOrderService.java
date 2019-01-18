package com.mb.demo.redis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.demo.redis.beans.HubTeamOrderEntity;
import com.mb.demo.redis.repository.HubTeamOrderRepository;

@Service
public class HubTeamOrderService {

	@Autowired
	HubTeamOrderRepository hubTeamOrderRepo;

	public HubTeamOrderEntity save(HubTeamOrderEntity pickerProducts) {
		return hubTeamOrderRepo.save(pickerProducts);
	}

	public HubTeamOrderEntity getById(String id) {
		Optional<HubTeamOrderEntity> pickerProducts = hubTeamOrderRepo.findById(id);
		return pickerProducts.orElse(null);
	}

	public List<HubTeamOrderEntity> getAll() {
		return (List<HubTeamOrderEntity>) hubTeamOrderRepo.findAll();
	}

	public void deleteById(String id) {
		hubTeamOrderRepo.deleteById(id);
	}

	public void deleteAll() {
		hubTeamOrderRepo.deleteAll();
	}
}
