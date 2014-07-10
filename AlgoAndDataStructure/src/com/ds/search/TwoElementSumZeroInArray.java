package com.ds.search;

import java.util.Arrays;

import com.ds.recursion.*;

public class TwoElementSumZeroInArray {

	//O(n2)
	public void twoElementSum(int[] array) {
		
		int min_i = 0;
		int min_j = 1;
		int min_sum = array[min_i] + array[min_j];
		
		for(int i = 0; i < array.length - 1; i++) {
			for(int j = i + 1; j < array.length; j++) {
				if(Math.abs(array[i] + array[j]) < Math.abs(min_sum)) {
					min_sum = array[i] + array[j];
					min_i = i;
					min_j = j;
				}
			}
		}
		
		System.out.println("One is " + array[min_i] + " : Other is " + array[min_j]);
	}
	
	//O(nlogn)
	public void twoElementSumBySorting(int[] array) {
		
		int positive_min_i = 0;
		int positive_min_j = 0;
		int negative_min_i = 0;
		int negative_min_j = 0;
		
		int positive = Integer.MAX_VALUE;
		int negative = Integer.MIN_VALUE;
		
		Arrays.sort(array);
		
		for(int i = 0, j = array.length - 1; i < j;) {
			
			int temp = array[i] + array[j];
			
			if(temp > 0) {

				if(temp < positive) {
					positive = temp;
					positive_min_i = i;
					positive_min_j = j;
				}
				j--;
			}
			else if(temp < 0) {
				
				if(temp > negative) {
					negative = temp;
					negative_min_i = i;
					negative_min_j = j;
				}
				i++;
			}
			else {
				System.out.println("One is " + array[i] + " : Other is " + array[j]);
				return;
			} 
		}		
		
		if(Math.abs(negative) > positive)
			System.out.println("One is " + array[positive_min_i] + " : Other is " + array[positive_min_j]);
		else
			System.out.println("One is " + array[negative_min_i] + " : Other is " + array[negative_min_j]);
			
	}
	
	public static void main(String[] args) {

		TwoElementSumZeroInArray obj = new TwoElementSumZeroInArray();
		obj.twoElementSum(new int[]{-1,-2,2,4,5});
		obj.twoElementSumBySorting(new int[]{-1,-2,2,4,5});
	}

}
