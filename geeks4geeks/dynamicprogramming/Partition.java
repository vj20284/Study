package com.practise.geeks4geeks.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class Partition {
	public boolean partition(List<Integer> numbers) {
		int total = 0;
		for (int i = 0; i < numbers.size(); i++) {
			total += numbers.get(i);
		}
		
		if (total % 2 != 0)
			return false;
		
		boolean[][] soln = new boolean[total / 2 + 1][numbers.size() + 1];
		
		for (int i = 0; i <= numbers.size(); i++) {
			soln[0][i] = true;
		}
		
		for (int i = 0; i <= total / 2; i++) {
			soln[i][0] = false;
		}
		
		for (int i = 1; i <= total / 2; i++)  
	     {
	       for (int j = 1; j <= numbers.size(); j++)  
	       {
	         soln[i][j] = soln[i][j-1];
	         if (i >= numbers.get(j - 1))
	           soln[i][j] = soln[i][j] || soln[i - numbers.get(j-1)][j-1];
	       }        
	     }    
		
		return soln[total/2][numbers.size()];
	}
	
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(5);
		numbers.add(3);
		numbers.add(11);
		
		Partition p = new Partition();
		System.out.println(p.partition(numbers));
	}
}