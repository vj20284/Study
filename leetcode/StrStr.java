package com.practise.leetcode;

import org.junit.Test;

public class StrStr {
	
	@Test
	public void testStrStr() {
		String haystack = "This is a haystack";
		String needle = "hay";
		System.out.println("Found : " + strStr(haystack, needle));
	}
	
	public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (needle == null || needle.length() == 0)
            return haystack;
        int p1 = 0;
        int sizeHaystack = haystack.length();
        int sizeNeedle = needle.length();
        while (p1 < sizeHaystack) {
            int pBegin = p1;
            int p2= 0;
            while (p1 < sizeHaystack && p2 < sizeNeedle && 
                haystack.charAt(p1) == needle.charAt(p2)) {
                    p1++;
                    p2++;
                }
            
            if (p2 == sizeNeedle)
                return haystack.substring(pBegin, pBegin + sizeNeedle);
            p1 = pBegin + 1;
        }
        
        return null;
    }
}
