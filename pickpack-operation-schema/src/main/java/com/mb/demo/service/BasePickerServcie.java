package com.mb.demo.service;

import java.util.List;

public interface BasePickerServcie<T> {

	public void add(T t);

	public T getById(long id);

	public List<T> getAll();

	public void deleteById(long id);

	public void update(T t);
}
