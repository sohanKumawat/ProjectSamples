package com.demo.slk.application.esshopifybacthprocesing.batch.reader;

import java.util.List;

import com.demo.slk.application.esshopifybacthprocesing.batch.pojo.system.DataItemRead;

public interface CollectionDataReader<T> extends DataReader<T> {

	@SuppressWarnings("hiding")
	public <T extends DataItemRead> T collectionById(String collectionId) throws Exception;

	@SuppressWarnings("hiding")
	public <T extends DataItemRead> List<T> fromToCollectionReader(int start, int end) throws Exception;

	@SuppressWarnings("hiding")
	public <T extends DataItemRead> List<T> allCollection() throws Exception;

}
