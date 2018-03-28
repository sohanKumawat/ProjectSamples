package com.demo.slk.design.vedingmachine;

import java.util.List;

import com.demo.slk.design.vedingmachine.model.Bucket;
import com.demo.slk.design.vedingmachine.model.Coin;
import com.demo.slk.design.vedingmachine.model.Item;
import com.demo.slk.design.vedingmachine.service.VendingMachine;
import com.demo.slk.design.vedingmachine.service.VendingMachineFactory;

public class MachineDemo {

	public static void main(String[] str){
		VendingMachine vMachine=	VendingMachineFactory.createVendingMachine();
		vMachine.selectItemAndGetPrice(Item.PEPSI);
		vMachine.insertCoin(Coin.QUARTER);
		vMachine.insertCoin(Coin.QUARTER);
		Bucket<Item, List<Coin>> result=vMachine.collectItemAndChange();
		System.out.println(result.toString());
	}
	
}
