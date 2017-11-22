package com.netent.platform.hiring.stockTrader.impl;

import com.netent.platform.hiring.stockTrader.api.DematServiceIF;
import com.netent.platform.hiring.stockTrader.api.StockTraderServiceFactoryIF;
import com.netent.platform.hiring.stockTrader.api.TradingServiceIF;

public class StockTraderServiceFactory implements StockTraderServiceFactoryIF{

	@Override
	public TradingServiceIF tradingService() {
		// TODO Add implementation here
		return null;
	}

	@Override
	public DematServiceIF dematService() {
		// TODO Add implementation here
		return null;
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
