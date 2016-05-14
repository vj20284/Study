package com.practise.geeks4geeks.recursionbacktracking;

public class EggDrop {
	/* Function to get minimum number of trails needed in worst
	  case with n eggs and k floors */
	int eggDrop(int n, int k)
	{
	    // If there are no floors, then no trials needed. OR if there is
	    // one floor, one trial needed.
	    if (k == 1 || k == 0)
	        return k;
	 
	    // We need k trials for one egg and k floors
	    if (n == 1)
	        return k;
	 
	    int min = Integer.MAX_VALUE, res;
	 
	    // Consider all droppings from 1st floor to kth floor and
	    // return the minimum of these values plus 1.
	    for (int x = 1; x <= k; x++)
	    {
	        res = Math.max(eggDrop(n-1, x-1), eggDrop(n, k-x));
	        if (res < min)
	            min = res;
	    }
	 
	    return min + 1;
	}
}
