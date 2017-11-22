package com.netent.platform.hiring.stockTrader.impl;

import com.netent.platform.hiring.stockTrader.api.DematServiceIF;
import com.netent.platform.hiring.stockTrader.api.StockTraderServiceFactoryIF;
import com.netent.platform.hiring.stockTrader.api.TradingServiceIF;
/**
 * StockTraderServiceFactory factory class used to return instance of specific service class
 * 
 * tradingService method return {@link TradingService} service instance
 * 
 * dematService method return {@link DematService} service instance
 * 
 * @author aditya.bhushan
 *
 */
public class StockTraderServiceFactory implements StockTraderServiceFactoryIF{

	@Override
	public TradingServiceIF tradingService() {
		return new TradingService();
	}

	@Override
	public DematServiceIF dematService() {
		return new DematService();
	}

	@Override
	public void bootstrap() {
		// TODO Add implementation here
		
	}
	
	@Override
	public void cleanup() {
		// TODO Add implementation here
		
	}

}
