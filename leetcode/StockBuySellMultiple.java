package com.practise.leetcode;

import java.util.ArrayList;
import java.util.List;

public class StockBuySellMultiple {
	public static void getBestTime(int prices[]) {
		List<Integer> buy = new ArrayList<Integer>();
		List<Integer> sell = new ArrayList<Integer>();
		
		boolean buying = true;
		int buying_price = 0;
		int profit = 0;

		for(int i = 0; i < prices.length - 1; ++i)
		{
			if(buying)
			{
				if(prices[i] < prices[i + 1])
				{
					buying_price = prices[i];
					buy.add(prices[i]);
					buying = false;
				}
			}
			else if(prices[i] > prices[i + 1])
			{
				profit += prices[i] - buying_price;
				sell.add(prices[i]);
				buying = true;
			}
		}

		if(!buying) // The last price is the highest one!
		{
			profit += prices[prices.length - 1] - buying_price;
			sell.add(prices[prices.length - 1]);
		}
		System.out.println("Profit : " + profit);
		for (int i = 0 ; i < buy.size(); i++) {
			System.out.println("Buy at: " + buy.get(i) + " Sell for : " + sell.get(i) + " Profit is : " + (sell.get(i) - buy.get(i)));
		}
	}

	public static void main(String[] args) {
		int[] stocks = new int[] {5, 7, 6, 3, 1, 8, 4, 3, 9};
		getBestTime(stocks);
	}
}
