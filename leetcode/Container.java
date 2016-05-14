package com.practise.leetcode;

import java.util.TreeSet;

import org.junit.Test;

public class Container {
	
	//1,2
	//2,1
	//0,2
	//2,0
	//1,2,1
	//1,2,4,3
	//3,2,1,3
	//4,3,2,1,4
	//2,3,10,5,7,8,9
	//1,2,3,4,5,6,7,8,9,10
	//10,9,8,7,6,5,4,3,2,1
	@Test
	public void testContainer() {
		int heights[] = new int[] {10,9,8,7,6,5,4,3,2,1};		
		System.out.println(maxArea(heights));
	}

	public int maxArea(int[] height) {
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
