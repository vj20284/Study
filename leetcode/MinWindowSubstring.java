package com.practise.leetcode;

import org.junit.Test;

public class MinWindowSubstring {
	
	@Test
	public void TestMinWindowSubstr() {
		String S = "This is a test";
		String T = "ate";
		minimumWindow(S, T);
		//minWindow(S, T, 0, S.length());
	}
	
	boolean minWindow(String S, String T,
			int minWindowBegin, int minWindowEnd) {
		int sLen = S.length();
		int tLen = T.length();
		int needToFind[] = new int[256];

		for (int i = 0; i < tLen; i++)
			needToFind[T.charAt(i)]++;

		int hasFound[] = new int[256];
		int minWindowLen = 999;
		int count = 0;
		for (int begin = 0, end = 0; end < sLen; end++) {
			// skip characters not in T
			if (needToFind[S.charAt(end)] == 0) continue;
			hasFound[S.charAt(end)]++;
			if (hasFound[S.charAt(end)] <= needToFind[S.charAt(end)])
				count++;

			// if window constraint is satisfied
			if (count == tLen) {
				// advance begin index as far right as possible,
				// stop when advancing breaks window constraint.
				while (needToFind[S.charAt(begin)] == 0 ||
						hasFound[S.charAt(begin)] > needToFind[S.charAt(begin)]) {
					if (hasFound[S.charAt(begin)] > needToFind[S.charAt(begin)])
						hasFound[S.charAt(begin)]--;
					begin++;
				}

				// update minWindow if a minimum length is met
				int windowLen = end - begin + 1;
				if (windowLen < minWindowLen) {
					minWindowBegin = begin;
					minWindowEnd = end;
					minWindowLen = windowLen;
				} // end if
			} // end if
		} // end for

		for (int i = minWindowBegin; i <= minWindowEnd; i++) {
			System.out.print(S.charAt(i));
		}
		return (count == tLen) ? true : false;
	}
	
	String minimumWindow(String S, String T) {
		int minWindowBegin = 0;
		int minWindowEnd = S.length();
		int sLen = S.length();
		int tLen = T.length();
		int needToFind[] = new int[256];

		for (int i = 0; i < tLen; i++)
			needToFind[T.charAt(i)]++;

		int hasFound[] = new int[256];
		int minWindowLen = 999;
		int count = 0;
		for (int begin = 0, end = 0; end < sLen; end++) {
			// skip characters not in T
			if (needToFind[S.charAt(end)] == 0) 
				continue;
			hasFound[S.charAt(end)]++;
			if (hasFound[S.charAt(end)] <= needToFind[S.charAt(end)])
				count++;

			// if window constraint is satisfied
			if (count == tLen) {
				// advance begin index as far right as possible,
				// stop when advancing breaks window constraint.
				while (needToFind[S.charAt(begin)] == 0 ||
						hasFound[S.charAt(begin)] > needToFind[S.charAt(begin)]) {
					if (hasFound[S.charAt(begin)] > needToFind[S.charAt(begin)])
						hasFound[S.charAt(begin)]--;
					begin++;
				}

				// update minWindow if a minimum length is met
				int windowLen = end - begin + 1;
				if (windowLen < minWindowLen) {
					minWindowBegin = begin;
					minWindowEnd = end;
					minWindowLen = windowLen;
				} // end if
			} // end if
		} // end for

		for (int i = minWindowBegin; i <= minWindowEnd; i++) {
			System.out.print(S.charAt(i));
		}
		return S.substring(minWindowBegin, minWindowEnd+1);
	}

}
