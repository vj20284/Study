package com.practise.leetcode;

import java.util.Stack;

import org.junit.Test;

public class HistogramRectangle {
	
	@Test
	public void TestRectangleArea() {
		int[] height = new int[] {2,1,5,6,2,3};
		System.out.println("Area : " + largestArea(height));
	}

	int largestArea(int arr[])
	{
		int len = arr.length;
		int area[] = new int[arr.length]; //initialize it to 0
		int n, i, t;
		Stack<Integer> St = new Stack<Integer>();  //include stack for using this #include<stack>
		
		for (i=0; i<len; i++)
		{
			while (!St.empty())
			{
				if(arr[i] <= arr[St.peek()])
				{
					St.pop();
				}
				else
					break;
			}
			if(St.empty())
				t = -1;
			else
				t = St.peek();
			//Calculating Li
			area[i] = i - t - 1;
			St.push(i);
		}

		//clearing stack for finding Ri
		while (!St.empty())
			St.pop();

		for (i=len-1; i>=0; i--)
		{
			while (!St.empty())
			{
				if(arr[i] <= arr[St.peek()])
				{
					St.pop();
				}
				else
					break;
			}
			if(St.empty())
				t = len;
			else
				t = St.peek();
			//calculating Ri, after this step area[i] = Li + Ri
			area[i] += t - i -1;
			St.push(i);
		}

		int max = 0;
		//Calculating Area[i] and find max Area
		for (i=0; i<len; i++)
		{
			area[i] = arr[i] * (area[i] + 1);
			if (area[i] > max)
				max = area[i];
		}

		return max;
	}

}
