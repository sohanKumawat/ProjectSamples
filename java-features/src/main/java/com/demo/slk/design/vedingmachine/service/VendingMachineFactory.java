package com.demo.slk.design.vedingmachine.service;

public class VendingMachineFactory {
	public static VendingMachine createVendingMachine() {
		return new VendingMachineImpl();
	}

}
