package com.ds.search;

import java.util.Arrays;

public class MaxCountElementInArray {

	//O(n2)
	public int maxCountElement(int[] array) {
		
		int maxI = Integer.MIN_VALUE, maxCount = Integer.MIN_VALUE;
		
		for(int i = 0; i < array.length; i++) {
			
			int count = 0;
			for(int j = i + 1; j < array.length; j++) {
				if(array[i] == array[j]) {
					count++;
				}
			}
			if(count > maxCount)  {
				maxCount = count;
				maxI = i;
			}
		}
		
		return (maxCount == 0) ? (-1) : array[maxI];
	}
	
	//O(nlogn)
	public int maxCountElementBySorting(int[] array) {
		
		int maxI = Integer.MIN_VALUE, maxCount = Integer.MIN_VALUE;
		Arrays.sort(array);
		
		for(int i = 0; i < array.length - 1; i++) {
			int count = 0;
			while(i + 1 < array.length && array[i] == array[i + 1]) {
				i++;
				count++;
			}
			
			if(count > maxCount)  {
				maxCount = count;
				maxI = i;
			}
		}
		
		return (maxCount == 0) ? (-1) : array[maxI];
	}
	
	//O(n)
	//Only work for positive numbers
	//Only works for values that is between 0 and n - 1
	public int maxCountElementEfficient(int[] array) {
		
		int length = array.length;
		int maxI = Integer.MIN_VALUE, maxCount = Integer.MIN_VALUE;
		
		for(int i = 0; i < length; i++) {
			array[array[i] % length] = array[array[i]  % length] + length; 
		}
		
		for(int i = 0; i < length; i++) {
			if(array[i]/length > maxCount) {
				maxI = i;
				maxCount = array[i]/length;
			}
		}
		
		return maxI;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MaxCountElementInArray obj = new MaxCountElementInArray();
		//System.out.println(obj.maxCountElement(new int[]{1,1,1,4,4,4,4}));
		//System.out.println(obj.maxCountElementBySorting(new int[]{1,4}));
		System.out.println(obj.maxCountElementEfficient(new int[]{1,2,3,4}));
	}

}
