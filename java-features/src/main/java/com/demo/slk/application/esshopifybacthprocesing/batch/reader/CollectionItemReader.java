package com.demo.slk.application.esshopifybacthprocesing.batch.reader;

public interface CollectionItemReader<T> extends DataReader<T> {
	public void collectionById(String id);

	public void allCollection();

	public void fromToCollectionReader(int start, int end);
}
