package com.demo.slk.application.cache.dozer;

import java.io.IOException;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class BeanAdapterHelper {
	static DozerBeanMapper mapper;

	@SuppressWarnings("static-access")
	@Autowired
	public BeanAdapterHelper(DozerBeanMapper mapper) {
		this.mapper = mapper;
	}

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

	public static <S, T> T fromString(String jsonData, Class<S> source, Class<T> target) {
		try {
			return mapper.map(OBJECT_MAPPER.readValue(jsonData, source), target);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static <T> T sourceToTarget(Object source, Class<T> target) throws Throwable {
		return mapper.map(source, target);
	}
}
