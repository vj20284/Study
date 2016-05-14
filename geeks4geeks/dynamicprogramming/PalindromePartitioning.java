package com.practise.geeks4geeks.dynamicprogramming;

public class PalindromePartitioning {
	public int partition(String s) {
		int[] soln = new int[s.length()];
		int[][] pal = new int[s.length()][s.length()];
		
		for (int L = 2; L <= s.length(); L++)
	    {
	        // For substring of length L, set different possible starting indexes
	        for (int i = 0; i < s.length() - L+1; i++)
	        {
	            int j = i+L-1; // Set ending index	  
	            if (L == 2)
	                pal[i][j] = s.charAt(i) == s.charAt(j) ? 1 : 0;
	            else
	                pal[i][j] = s.charAt(i) == s.charAt(j) && pal[i+1][j-1] == 1 ? 1 : 0;
	        }
	    }
				
		for (int i = 0; i < s.length(); i++)
	    {
	        if (pal[0][i] == 1)
	            soln[i] = 0;
	        else
	        {
	            soln[i] = Integer.MAX_VALUE;
	            for (int j = 0; j < i; j++)
	            {
	                if (pal[j+1][i] == 1 && 1 + soln[j] < soln[i])
	                    soln[i] = 1 + soln[j];
	            }
	        }
	    }
		return soln[s.length() - 1];
	}
}
