package com.demo.slk.application.esshopifybacthprocesing.es.service;

public interface BaseCurdService {
	<T> void save(T t);
	<T> T findAll();
	<T> void update(T t);
}
