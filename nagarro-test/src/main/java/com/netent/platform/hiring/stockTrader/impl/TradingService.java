package com.netent.platform.hiring.stockTrader.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.netent.platform.hiring.stockTrader.api.DataStorage;
import com.netent.platform.hiring.stockTrader.api.InvalidTransactionRequestException;
import com.netent.platform.hiring.stockTrader.api.Stock;
import com.netent.platform.hiring.stockTrader.api.StockTransferTransactionRequest;
import com.netent.platform.hiring.stockTrader.api.TradingServiceIF;
/**
 * TradingService class used to allow trading of Stock amongst users
 * 
 * @author sohan kumawat
 *
 */
public class TradingService implements TradingServiceIF {
	Gson gson = new Gson();

	@Override
	public void executeStockTransfer(List<StockTransferTransactionRequest> transferTransactions)
			throws InvalidTransactionRequestException {
		System.out.println("Input  " + gson.toJson(transferTransactions));
		try {
			Map<String, List<StockTransferTransactionRequest>> uStocks = DataStorage.userStock;
			System.out.println("persist data ** " + gson.toJson(uStocks));
			Map<Stock, List<StockTransferTransactionRequest>> transactions = transferTransactions.stream()
					.filter(txn -> {
						try {
							if (txn.getQuantity() < 0) {
								int ustockCount = uStocks.get(txn.getUserName()).stream()
										.filter(utxn -> utxn.getStock().equals(txn.getStock()))
										.map(utxn -> utxn.getQuantity()).reduce(0, (a, b) -> a + b);
								if (ustockCount + txn.getQuantity() >= 0)
									return true;
								else
									return false;
							}
							return true;
						} catch (ClassCastException ex) {
							ex.printStackTrace();
						} catch (Exception ex) {
							ex.printStackTrace();
						}
						return false;
					}).collect(Collectors.groupingBy(StockTransferTransactionRequest::getStock));

			System.out.println("transaction 1**  " + gson.toJson(transactions));
			List<StockTransferTransactionRequest> transactionToPeform = (List<StockTransferTransactionRequest>) transactions
					.entrySet().stream().filter(tmap -> {
						try {
							int stockCount = tmap.getValue().stream().map(lst -> lst.getQuantity()).reduce(0,
									(a, b) -> a + b);
							int size = tmap.getValue().size();
							return size % 2 == 0 && stockCount == 0;
						} catch (Exception ex) {
							ex.printStackTrace();
						}
						return false;
					}).map(vmap -> vmap.getValue()).flatMap(List::stream).collect(Collectors.toList());
			System.out.println("transactionToPeform condition - " + gson.toJson(transactionToPeform));
			for (StockTransferTransactionRequest transaction : transactionToPeform) {
				if (DataStorage.userStock.containsKey(transaction.getUserName())) {
					DataStorage.userStock.get(transaction.getUserName()).add(transaction);
				} else {
					List<StockTransferTransactionRequest> txn = new ArrayList<>();
					txn.add(transaction);
					DataStorage.userStock.put(transaction.getUserName(), txn);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new InvalidTransactionRequestException("executeStockTransfer " + ex.getMessage());
		}
	}

	@Override
	public Optional<List<StockTransferTransactionRequest>> findTransferTransactions(String userName) {
		Objects.requireNonNull(userName, "User name should not be blank");
		System.out.println("findTransferTransactions -- " + gson.toJson(DataStorage.userStock.get(userName)));
		return Optional.ofNullable(DataStorage.userStock.get(userName));
	}

	@Override
	public Optional<Map<String, Integer>> findUsersWithStock(Stock stock) {
		Objects.requireNonNull(stock, "Stock should not be blank");
		try {
			Map<String, Integer> userStock = DataStorage.userStock.values().stream().flatMap(List::stream)
					.filter(utxns -> utxns.getStock().equals(stock))
					.collect(Collectors.toMap(StockTransferTransactionRequest::getUserName,
							StockTransferTransactionRequest::getQuantity, (v1, v2) -> v1 + v2));
			System.out.println("findUsersWithStock -- " + gson.toJson(userStock));
			return Optional.ofNullable(userStock);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
