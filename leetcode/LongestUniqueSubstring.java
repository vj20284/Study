package com.practise.leetcode;

/*Given a string, find the length of the longest substring without repeating characters. 
 *For example, the longest substring without repeating letters for “abcabcbb” is “abc”, 
 *which the length is 3. For “bbbbb” the longest substring is “b”, with the length of 1.
 * */

public class LongestUniqueSubstring {
	private static int[] visited = new int[26];
	
	static {
		for (int i = 0 ; i < visited.length; i++) {
			visited[i] = -1;
		}
	}

	public static String LongestSubstring(String s) {
		int maxLen = 0;
		int start = 0;
		int end = 0;
		int prevIndex;
		Character c = s.charAt(0);
		visited[c - 'a'] = 0;
		int curLen = 1;
		
		for (int i = 1; i < s.length(); i++) {
			c = s.charAt(i);
			prevIndex = visited[c - 'a'];
			
			if (prevIndex == -1 || i - curLen > prevIndex) {
				curLen++;
			}
			else {
				if (curLen > maxLen) {
					end = i;
					maxLen = curLen;
				}
				curLen = i - prevIndex;
			}
			visited[c - 'a'] = i;
		}
		start = end - maxLen;
		return s.substring(start, end) ;
	}

	
	public static void main(String[] args) {
		String s = LongestUniqueSubstring.LongestSubstring("abcabcbbabcdea");
		System.out.println(s);
	}
}
