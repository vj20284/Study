package com.practise.leetcode;

import java.util.List;

import org.junit.Test;

public class ClimbingStairs {
	//You are climbing a stair case. It takes n steps to reach to the top.
	//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?


	public int climbStairs(int numStairs) {
		if (numStairs <= 1) {
			return 1;
		}
		if (numStairs == 2) {
			return 2;
		}
		return climbStairs(numStairs - 1) + climbStairs(numStairs - 2);
	}
}
