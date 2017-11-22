package com.netent.platform.hiring.stockTrader.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.netent.platform.hiring.stockTrader.api.DataStorage;
import com.netent.platform.hiring.stockTrader.api.DematServiceIF;
import com.netent.platform.hiring.stockTrader.api.InvalidTransactionRequestException;
import com.netent.platform.hiring.stockTrader.api.Stock;
import com.netent.platform.hiring.stockTrader.api.StockTransferTransactionRequest;
/**
 * DematService class used to perform demat operations
 * allocateStock method used to allocate stock to specific user
 * 
 * @author sohan kumawat
 *
 */
public class DematService implements DematServiceIF {

	@Override
	public void allocateStock(String userName, Stock stock, Integer quantity)
			throws InvalidTransactionRequestException {
		if (quantity < 0)
			throw new InvalidTransactionRequestException("Stock quantity should be equal or greater than 0");
		StockTransferTransactionRequest transaction = StockTransferTransactionRequest.builder().user(userName)
				.stock(stock).quantity(quantity).build();
		if (DataStorage.userStock.containsKey(userName)) {
			DataStorage.userStock.get(userName).add(transaction);
		} else {
			List<StockTransferTransactionRequest> transactions = new ArrayList<>();
			transactions.add(transaction);
			DataStorage.userStock.put(userName, transactions);
		}

	}

	@Override
	public Optional<Integer> getStockStatus(String userName, Stock stock) {
		String msg = "";
		msg = (null == userName || userName.length() <= 0) ? "userName should not be blank"
				: (null == stock || null == stock.getStockSymbol() || stock.getStockSymbol().length() <= 0)
						? "Stock should not be blank" : msg;
		if (msg.length() > 0){
			//throw new InvalidTransactionRequestException(msg);
			return null;
		}
		if(DataStorage.userStock.containsKey(userName)){
			Stock stk=stock;
		return Optional.ofNullable(DataStorage.userStock.get(userName).stream().
			filter(transaction->transaction.getStock().equals(stk)).
			map(transaction ->transaction.getQuantity()).collect(Collectors.reducing(0,(a,b) -> a+b)));
		}
		return null;
	}
}
