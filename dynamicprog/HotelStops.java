package com.practise.dynamicprog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelStops {

	public static void GetHotelStops(int[] distances) {
		Map<Integer, Integer> path = new HashMap<Integer, Integer>();
		Map<Integer, Integer> penaltiesMap = new HashMap<Integer, Integer>();
		penaltiesMap.put(0, 0);
		path.put(0, 0);
		for (int i = 0; i <= distances.length - 1; i++) {
			for(int j = 0; j <= i; j++){
				int currentPenalty = (int)(penaltiesMap.get(j) + Math.pow(200 - (distances[i] - distances[j]), 2));
				if(penaltiesMap.get(i) == null || currentPenalty < penaltiesMap.get(i)){
					path.put(i, j);
					penaltiesMap.put(i, currentPenalty);
				}
			}
		}
		for (Integer i : penaltiesMap.keySet()) {
			System.out.println("Stop at hotel : " + i + " at distance of : " + distances[i] + " with penalty : " + penaltiesMap.get(i));
		}
		for (int i = 1; i < distances.length; i++) {
			printPath(path, i);	
		}
	}
	
	private static void printPath(Map<Integer, Integer> path, Integer dest) {
		int temp = dest;
		System.out.println("\nPath to : " + dest);
		System.out.print(temp);
		while(temp != 0) {
			System.out.print("->" + path.get(temp));
			temp = path.get(temp);
		}
	}
	
	public static void main(String[] args) {
		int[] distances = new int[] {200, 400, 600, 750, 800, 900, 1000};
		//int[] distances = new int[] {200, 300, 400, 600, 900, 1300, 1400, 1700, 1750, 1800};
		HotelStops.GetHotelStops(distances);
	}
}

/*
 * PN + [200 - (AN - AM)]^2
*/