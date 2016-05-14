package com.practise.dynamicprog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinChange {
	static int[] denominations = new int[] {5, 10, 25, 100};

	public int M(int target)
	{
		int[] M;
		int[] sol, mySol;
		int j, k, min;

		M = new int[target+1];
		sol = new int[denominations.length];
		mySol = new int[denominations.length];

		/* ---------------------------
		  Base cases
		  --------------------------- */
		M[0] = 0;	// 0 coins needed to make change for $0

		/* ---------------------------------------------------
		  The other cases (starting from 1 to M.length - 1)
		  --------------------------------------------------- */
		for ( j = 1; j <= target; j++ )
		{
			/* --------------------------------------------------------
	             Try every denomination k = 1,2,..,C for the last coin
	             -------------------------------------------------------- */
			for ( k = 0; k < denominations.length; k++ )
				mySol[k] = -1;                   // Initialize mySol[]

			for ( k = 0; k < denominations.length; k++ )
			{
				/* --------------------------------------------
	                Check if we can use the k-th denomination
	                -------------------------------------------- */
				if ( denominations[k] <= j )
				{
					/* ------------------------
	                   Divide step
	                   ------------------------ */
					sol[k] = M[j - denominations[k]];     // Use coin v[k] as last coin
					mySol[k] = sol[k] + 1;    // Solution to make change for $j
				}
			}

			/* --------------------------------------------------------
	             Find the minimum
	             -------------------------------------------------------- */
			M[j] = -1;

			for ( k = 0; k < denominations.length; k++ )
			{
				if ( mySol[k] >= 0 )
				{
					if ( M[j] == -1 || mySol[k] < M[j] )
						M[j] = mySol[k];
				}
			}
		}

		return( M[target] );
	}


	public static void main(String[] args)
	{
		int target = 1000;

		CoinChange cc = new CoinChange();
		int r = cc.M(target);

		System.out.println("Min # coins to make change for " + target + " = " + r);
		System.out.println("=======================\n");
	}

}
