package com.practise.algorithms.designmanual.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class EditDistance {
	public int editDistance(String a, String b) {
		int[][] soln = new int[a.length() + 1][b.length() + 1];
		char[][] path = new char[a.length() + 1][b.length() + 1];
		
		for (int i = 0; i <= a.length(); i++) {
			soln[i][0] = i;
			path[i][0] = 'D';
		}
		
		for (int i = 0; i <= b.length(); i++) {
			soln[0][i] = i;
			path[0][i] = 'I';
		}
		
		for (int i = 1; i <= a.length(); i++) {
			for (int j = 1; j <= b.length(); j++) {
				path[i][j] = a.charAt(i - 1) == b.charAt(j - 1) ? 'M' : 'S';
				soln[i][j] = soln[i - 1][j - 1] + (a.charAt(i - 1) == b.charAt(j - 1) ? 0 : 1);
				int ins = soln[i][j - 1] + 1;
				int del = soln[i - 1][j] + 1;
				if (ins < soln[i][j] || del < soln[i][j]) {
					soln[i][j] = Math.min(ins, del);
					path[i][j] = ins < del ? 'I' : 'D';
				}
			}
		}
		printPath(path);
 		return soln[a.length()][b.length()];
	}
	
	public void printPath(char[][] path) {
		List<Character> ret = new ArrayList<Character>();
		int startRow = path.length - 1;
		int startCol = path[0].length - 1;
		
		while (startRow != 0 || startCol != 0) {
			Character curChar = path[startRow][startCol];
			ret.add(0, curChar);
			if (curChar == 'M' || curChar == 'S') {
				startRow--;
				startCol--;
			} else if (curChar == 'D') {
				startRow--;
			} else {
				startCol--;
			}
		}
		for (Character c : ret) {
			System.out.print(c);
		}
		return;
	}
	
	public static void main(String[] args) {
		EditDistance ed = new EditDistance();
		
		System.out.println("\n" + ed.editDistance("bisbu", "bunsaw"));
	}
}
