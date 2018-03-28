package com.demo.slk.design.vedingmachine.service;

import java.util.List;

import com.demo.slk.design.vedingmachine.model.Bucket;
import com.demo.slk.design.vedingmachine.model.Coin;
import com.demo.slk.design.vedingmachine.model.Item;

public interface VendingMachine {
	public long selectItemAndGetPrice(Item item);

	public void insertCoin(Coin coin);

	public List<Coin> refund();

	public Bucket<Item, List<Coin>> collectItemAndChange();

	public void reset();
}
