
package com.practise.dynamicprog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinChange2 {
	static int[] denominations = new int[] {5, 10, 25, 100};

	public int M(int target)
	{
		int[] table;
		int[] sol, mySol;
		int j, k, min;

		table = new int[target+1];
		sol = new int[denominations.length];
		mySol = new int[denominations.length];

		table[0] = 0;

		for ( j = 1; j <= target; j++ )
		{
			for ( k = 0; k < denominations.length; k++ )
				mySol[k] = -1;

			for ( k = 0; k < denominations.length; k++ )
			{
				if ( denominations[k] <= j )
				{
					sol[k] = table[j - denominations[k]];     // Use coin v[k] as last coin
					mySol[k] = sol[k] + 1;    // Solution to make change for $j
				}
			}

			/* --------------------------------------------------------
	             Find the minimum
	             -------------------------------------------------------- */
			table[j] = -1;

			for ( k = 0; k < denominations.length; k++ )
			{
				if ( mySol[k] >= 0 )
				{
					if ( table[j] == -1 || mySol[k] < table[j] )
						table[j] = mySol[k];
				}
			}
		}

		return( table[target] );
	}


	public static void main(String[] args)
	{
		int target = 1000;

		CoinChange2 cc = new CoinChange2();
		int r = cc.M(target);

		System.out.println("Min # coins to make change for " + target + " = " + r);
		System.out.println("=======================\n");
	}

}
