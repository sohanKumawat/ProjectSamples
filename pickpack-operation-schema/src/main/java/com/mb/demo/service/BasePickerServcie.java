package com.mb.demo.service;

import java.util.List;

public interface BasePickerServcie<T> {

	public T add(T t);

	public T getById(long id);

	public List<T> getAll();

	public void deleteById(long id);

	public T update(T t);
}
