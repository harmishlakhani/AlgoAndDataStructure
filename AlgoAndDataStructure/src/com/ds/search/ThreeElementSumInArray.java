package com.ds.search;

import java.util.Arrays;

public class ThreeElementSumInArray {

	//O(n3)
	public void threeElementSum(int[] array, int K) {
		
		for(int i = 0; i < array.length; i++) {
			for(int j = i + 1; j < array.length; j++) {
				for(int k = j + 1; k < array.length; k++) {
					if(array[i] + array[j] + array[k] == K) {
						System.out.println("First is " + array[i] + " : Second is " + array[j] + " : Third is " + array[k]);
						return;
					}
				}
			}
		}
		
		System.out.println("No such element");
	}
	
	//O(nlogn) + O(n2)
	public void threeElementSumBySorting(int[] array, int K) {
		
		Arrays.sort(array);
		
		for(int k = 0; k < array.length; k++) {
			for(int i = k + 1,j = array.length - 1; i < j;) {
				int temp = array[i] + array[j] + array[k];
				if(temp == K) {
					System.out.println("First is " + array[i] + " : Second is " + array[j] + " : Third is " + array[k]);
					return;
				} else if(temp < K)
					i++;
				else 
					j--;
			}
		}
		
		System.out.println("No such element");
	}
	
	public static void main(String[] args) {

		ThreeElementSumInArray obj = new ThreeElementSumInArray();
		obj.threeElementSum(new int[]{1,2,3,4,5}, 12);
		obj.threeElementSumBySorting(new int[]{-1,-2,-3,4,5,6,10}, 0);
	}

}
