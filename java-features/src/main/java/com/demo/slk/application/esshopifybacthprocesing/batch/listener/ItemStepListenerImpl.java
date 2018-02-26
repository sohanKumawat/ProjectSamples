package com.demo.slk.application.esshopifybacthprocesing.batch.listener;

import java.util.List;

import org.springframework.batch.core.listener.ItemListenerSupport;

public class ItemStepListenerImpl<I, O> extends ItemListenerSupport<I, O> {
	@Override
	public void afterRead(I item) {
	}

	@Override
	public void beforeRead() {
	}

	@Override
	public void onReadError(Exception ex) {
	}

	@Override
	public void afterProcess(I item, O result) {
	}

	@Override
	public void beforeProcess(I item) {
	}

	@Override
	public void onProcessError(I item, Exception e) {
	}

	@Override
	public void afterWrite(List<? extends O> item) {
	}

	@Override
	public void beforeWrite(List<? extends O> item) {
	}

	@Override
	public void onWriteError(Exception ex, List<? extends O> item) {
	}
}
