package com.demo.slk.application.batchprocessing.batch.reader;

public interface CollectionItemReader extends RecordItemReader {
	public void collectionById(String id);

	public void allCollection();

	public void fromToCollectionReader(int start, int end);
}
