package com.practise.geeks4geeks.recursionbacktracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateBinary {
	public void generate(int n) {
		List<String> list = new ArrayList<String>();
		gen(list, 0, 0, "", n);
		for (String s : list) {
			System.out.println(s);
		}
	}
	
	private void gen(List<String> list, int ones, int zeros, String str, int count) {
		if (ones + zeros == count) {
			list.add(str);
			return;
		}
		if (zeros < ones) {
			gen(list, ones, zeros + 1, str + "0", count);
		}
		gen(list, ones + 1, zeros, str + "1", count);
	}
	
	public static void main(String[] args) {
		GenerateBinary gb = new GenerateBinary(); 
		gb.generate(4);
	}
}
