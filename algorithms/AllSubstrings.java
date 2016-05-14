package com.practise.algorithms;
//Write a program to print all substrings of a given string without using the substring api
public class AllSubstrings {
	
	public static void PrintAllSubstrings(String input) {
		for (int k = 0; k < input.length(); k++) {
			for (int start = 0; start < input.length() - k; start++) {
				printSubstring(input, start, start + k);
			}
		}
	}

	private static void printSubstring(String input, int start, int end) {
		for (int i = start; i <= end; i++) {
			System.out.print(input.charAt(i));
		}
		System.out.println();
		return;
	}
	
	public static void main(String[] args) {
		AllSubstrings.PrintAllSubstrings("abcdef");
	}
}