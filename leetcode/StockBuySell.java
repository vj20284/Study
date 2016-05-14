package com.practise.leetcode;

public class StockBuySell {
	public static void getBestTime(int stocks[]) {
		int[] min = new int[stocks.length];
		int[] profits = new int[stocks.length];
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = Integer.MIN_VALUE;
		int buy = 0;
		int sell = 0;
		
		for (int i = 0; i < stocks.length; i++) {
			if (stocks[i] < minPrice) {
				min[i] = stocks[i];
				minPrice = min[i];
				buy = minPrice;
			}
			profits[i] = stocks[i] - min[i];
		}
		System.out.println("Profit : " + maxProfit + " Buy : " + buy + " Sell : " + sell);
	}
	
	public static void main(String[] args) {
		int[] stocks = new int[] {5, 7, 6, 3, 1, 8, 4, 3, 9};
		getBestTime(stocks);
	}
}
