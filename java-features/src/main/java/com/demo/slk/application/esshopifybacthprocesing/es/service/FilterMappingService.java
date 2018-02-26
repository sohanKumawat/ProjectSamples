package com.demo.slk.application.esshopifybacthprocesing.es.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.slk.application.esshopifybacthprocesing.es.entity.PIProductFilterMapper;
import com.demo.slk.application.esshopifybacthprocesing.es.repository.FilterMappingRepository;

@Service
public class FilterMappingService implements BaseCurdService{

	@Autowired
	FilterMappingRepository filterMappingRepository;
	
	@Override
	public <T> void save(T t) {
		filterMappingRepository.save((PIProductFilterMapper)t);
	}

	@Override
	public <T> T findAll() {
		return null;
	}

	@Override
	public <T> void update(T t) {
		
	}

}
