package com.practise.leetcode;

import java.lang.reflect.Field;

import org.junit.Test;

public class FirstMissingPositive {
	
	@Test
	public void testFMP() {
		Integer array[] = new Integer[] {10,4,16,54,17,-7,21,15,25,31,61,1,6,12,21,46,16,56,54,12,23,20,38,63,2,27,35,11,13,47,13,11,61,39,0,14,42,8,16,54,50,12,-10,43,11,-1,24,38,-10,13,60,0,44,11,50,33,48,20,31,-4,2,54,-6,51,6};
		System.out.println(firstMissingPositive(array));
	}
	
	public int findMax(Integer array[]) {
		int retVal = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > retVal)
				retVal = array[i];
		}
		return retVal;
	}
	
	public int findMin(Integer array[]) {
		int retVal = 9999;
		for (int i = 0; i < array.length; i++) {
			if (array[i] < retVal)
				retVal = array[i];
		}
		return retVal > 0 ? retVal : 0;
	}
	
	//leetcode --> Find the first missing positive

	public int firstMissingPositive(Integer A[])
	{
		int max = findMax(A);
		int min = findMin(A);
		if (min == max) {
			if (min <= 1)
				return min + 1;
			else
				return  1; 
		}
		if (min > 1)
			return 1;
			
		int tempArray[] = new int[max + 1];
		
		for (int i = 0; i < A.length; i++)
		{
			if (A[i] > 0)
				tempArray[A[i]] = A[i];
		}
		
		for (int i = min + 1; i < tempArray.length; i++)
		{
			if (tempArray[i] == 0)
				return i;
		}
		
		return max + 1;
	}
	
	public int firstMissingPositive2(Integer A[])
	{
		for (int i = 0; i < A.length; i++)
		{
			if (A[i] == i + 1) // if number already in place
				continue;
			
			// if number is greater than 0 and within bounds of array and
			// number being copied is not equal to number being copied
			while (A[i] > 0 && A[i] <= A.length	&& A[i] != i + 1 && A[A[i]- 1] != A[i] ){
				swap (A[i], A[A[i] -1]);				
			}
		}
		
		for (int i = 0; i < A.length; i++)
			if (A[i] != i + 1)
				return i + 1;
		
		return A.length + 1;	
	}

	public void swap(Integer i, Integer j) {
		try{
			   Integer lastJ = new Integer(j);
			   Field value = Integer.class.getDeclaredField("value");
			   value.setAccessible(true);
			   value.set(j, i); 
			   value.set(i, lastJ);
			   value.setAccessible(false);
			  }catch(Exception e){
			   e.printStackTrace();
			  }
	}
}
