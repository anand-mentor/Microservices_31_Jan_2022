package com.zensar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.dto.Stock;

@RestController
@RequestMapping("/zenstockapp")
@CrossOrigin(origins= "*")
public class StockController {

	private static List<Stock> stocks = new ArrayList<Stock>();
	static {
		stocks.add(new Stock(1, "Zensar", "BSE", 2000));
		stocks.add(new Stock(2, "Microsoft", "NSE", 300));
	}
	
	@GetMapping(value="/account")
	public boolean sendAccountNo(@RequestParam("id") int accNo, @RequestHeader("auth-token")String authToken) {
		System.out.println("accNo = " + accNo);
		System.out.println("authToken = " + authToken);
		return true;
	}
	
	
	
	@DeleteMapping(value="/stock")
	public boolean deleteAllStocks() {
		stocks.clear();
		return true;
	}
	
	@DeleteMapping(value="/stock/{id}")
	public boolean deleteStockById(@PathVariable("id") int stockId) {
		Stock stock = getStockById(stockId);
		stocks.remove(stock);
		return true;
	}
	
	@PutMapping(value="/stock/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Stock updateStock(@RequestBody Stock stock, @PathVariable("id") int stockId) {
		Stock oldStock = getStockById(stockId);
		oldStock.setName(stock.getName());
		oldStock.setMarket(stock.getMarket());
		oldStock.setPrice(stock.getPrice());
		return oldStock;
	}
	
	@PostMapping(value="/stock", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Stock createStock(@RequestBody Stock stock) {
		stock.setId(stocks.size() + 1);
		stocks.add(stock);
		return stock;
	}
	
	@GetMapping(value="/stock/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Stock getStockById(@PathVariable("id") int stockId) {
		for(Stock stock: stocks) {
			if(stock.getId() == stockId)
				return stock;
		}
		return null;
	}

	@GetMapping(value="/stock", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Stock> getAllStocks() {
		return stocks;
	}
}
