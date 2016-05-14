package com.practise.algorithms.designmanual.backtracking;

import java.util.List;

import com.practise.leetcode.GrayCode;

public class PeopleRoomGrayCode {

	public static void printRoomSequence(int n) {
		GrayCode code = new GrayCode();
		List<Integer> codes = code.grayCode(n);
		
		int step = 0;
		System.out.println("Step: " + step + ": No one in room");
		
		int pre = 0;
		
		for (step = 1; step < codes.size(); step ++){
			int v = codes.get(step);
			if (v > pre){
				//some one enter the room
				int p = getBitPosition(v-pre);
				System.out.println("Step: " + step + ": No." + p + " enter the room");
			} else {
				//some one leave the room
				int p = getBitPosition(pre-v);
				System.out.println("Step: " + step + ": No." + p + " leave the room");
			}		
			pre = v;
		}
	}
	
	private static int getBitPosition(int v){
		int p = 0;
		while(v/10 > 0){
			v = v/10;
			p++;
		}
		return p;
	}
	
	public  static void main(String[] args){
		PeopleRoomGrayCode.printRoomSequence(5);
	}
}
