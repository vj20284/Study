package com.practise.leetcode;
import java.util.BitSet;

import org.junit.Test;

public class GenerateParentheses {
	
	@Test
	public void testGenerate(){
		generate (4);
	}
	
	public void generate(int pairs) {
		BitSet bitset = new BitSet(pairs * 2);
		bitset.set(0, true);
		bitset.set(pairs * 2 - 1, false);
		permute(bitset, 1, pairs * 2);
	}
	
	public void permute(BitSet bitset, int indexToSet, int length) {
		int numOpen = bitset.cardinality();
		int numClose = 0;
		for (int i = 0 ; i <= indexToSet - 1; i++) {
			if (bitset.get(i) == false)
				numClose++;
		}
		
		if (numOpen < numClose) {
			//System.out.println("Less open than close : " + numOpen);
			//printBitset(bitset, indexToSet);			
			return;
		}
		
		if (indexToSet == length - 1) {
			//System.out.println("All bits evaluated : cur " + indexToSet + " end " + length + " numOpen " + numOpen);
			//printBitset(bitset, length);
			if (numOpen == length - numOpen) {
				System.out.println("Valid string : ");					
				printBitset(bitset, length);
			}
			return;
		}
		
		bitset.set(indexToSet, false);
		//System.out.println("Calling permute on : ");
		//printBitset(bitset, indexToSet + 1);
		permute(bitset, indexToSet + 1, length);
		bitset.set(indexToSet, true);
		//System.out.println("Calling permute on : ");
		//printBitset(bitset, indexToSet + 1);
		permute(bitset, indexToSet + 1, length);
	}
	
	public void printBitset(BitSet bitset, int numBits) {
		for (int i = 0 ; i < numBits; i++) {
			if (bitset.get(i) == true)
				System.out.print("(");
			else
				System.out.print(")");
		}
		System.out.println("\n");
	}
}

/*
 * ****
 * 1**0
 *  10*0
 *       1010
 *  11*0
 *       1100
 *
 * ()()
 * (())
 */
