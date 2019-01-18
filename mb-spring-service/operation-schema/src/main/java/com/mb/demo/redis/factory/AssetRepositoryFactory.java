package com.mb.demo.redis.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mb.demo.repository.NodeProductMappingRespository;
import com.mb.demo.repository.NodeStorageDataRepository;

@Component
public class AssetRepositoryFactory {

	@Autowired
	NodeProductMappingRespository productShelfMapping;
	@Autowired
	NodeStorageDataRepository shelfMetaDataRepository;

	public NodeProductMappingRespository getProductShelfMapping() {
		return productShelfMapping;
	}

	public NodeStorageDataRepository getShelfMetaDataRepository() {
		return shelfMetaDataRepository;
	}

}
