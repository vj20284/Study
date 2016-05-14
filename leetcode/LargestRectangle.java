package com.practise.leetcode;

import org.junit.Test;

public class LargestRectangle {
	
	@Test
	public void TestRectangleArea() {
		int[] height = new int[] {2,1,5,6,2,3};
		System.out.println("Area : " + largestRectangleArea(height));
	}
	
	public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int area = 0;
    	int left = 0;
		int right = height.length - 1;
		int maxarea = area;
		while (left < right) {
			int shorterIndex = left;
			if (height[left] > height[right]) {
				shorterIndex = right;				
			}
			area = height[shorterIndex] *  (right - left);
			System.out.println("Area: " + area + " Ht : " + height[shorterIndex] + " Right : " + right + " Left : " + left);
			if (area > maxarea)
				maxarea = area;
			if (shorterIndex == right)
				right = right - 1;
			else 
				left = left + 1;
		}
		return maxarea;
    }
}
