package com.demo.slk.application.esshopifybacthprocesing.es.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.slk.application.esshopifybacthprocesing.es.entity.ClientInventoryHerarichy;
import com.demo.slk.application.esshopifybacthprocesing.es.repository.ClientInventoryHerarichyRepository;

@Service
public class ClientInventoryHerarichyService implements BaseCurdService {
	@Autowired
	ClientInventoryHerarichyRepository clientInventoryHerarichyRepository;

	@Override
	public <T> void save(T t) {
		clientInventoryHerarichyRepository.save((ClientInventoryHerarichy) t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T findAll() {
		return (T) clientInventoryHerarichyRepository.findAll();
	}

	@Override
	public <T> void update(T t) {

	}

	public List<ClientInventoryHerarichy> findByBotId(String botId, Pageable pageable) throws Exception {
		return clientInventoryHerarichyRepository.findByBotId(botId, pageable);
	}

	public Page<ClientInventoryHerarichy> findByBotIdAndParentId(String botId, String parentId, Pageable pageable)
			throws Exception {
		return clientInventoryHerarichyRepository.findByBotIdAndParentId(botId, parentId, pageable);
	}

	public Page<ClientInventoryHerarichy> findByBotIdAndParentIdAndchildId(String botId, String parentId,
			String childId, Pageable pageable) throws Exception {
		return clientInventoryHerarichyRepository.findByBotIdAndParentIdAndChildId(botId, parentId, childId, pageable);
	}

	public Page<ClientInventoryHerarichy> findByBotIdAndchildId(String botId, String childId, Pageable pageable)
			throws Exception {
		return clientInventoryHerarichyRepository.findByBotIdAndChildId(botId, childId, pageable);
	}

}
