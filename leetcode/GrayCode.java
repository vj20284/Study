package com.practise.leetcode;

import java.util.*;

import org.junit.Test;

public class GrayCode {
	@Test
	public void testGrayCode() {
		List<Integer> values = grayCode(5);
		for (Integer value : values) {
			System.out.print(value + " ");
		}
	}
	
	
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> retList = new ArrayList<Integer>();
        gray(retList, "", n);
        return retList;
    }
    
    public static void yarg(List<Integer> retList, String prefix, int n) {
        if (n == 0) retList.add(Integer.parseInt(prefix));
        else {
            gray(retList, prefix + "1", n - 1);
            yarg(retList, prefix + "0", n - 1);
        }
    }  

    // append order n gray code to end of prefix string, and print
    public static void gray(List<Integer> retList, String prefix, int n) {
        if (n == 0) retList.add(Integer.parseInt(prefix));
        else {
            gray(retList, prefix + "0", n - 1);
            yarg(retList, prefix + "1", n - 1);
        }
    }  
    
}