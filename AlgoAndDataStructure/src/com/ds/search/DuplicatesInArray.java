package com.ds.search;

import java.util.Arrays;

public class DuplicatesInArray {

	//O(n2)
	public void checkDuplicates(int[] array) {
		
		for(int i = 0; i < array.length; i++) {
			for(int j = i + 1; j < array.length; j++) {
				
				if(array[i] == array[j]) {
					System.out.println("Duplicate Exists");
					return;
				}
			}
		}
		System.out.println("Duplicate doesn't exists");
	}
	
	//O(nlogn)
	public void checkDuplicatesBySorting(int[] array) {
		
		Arrays.sort(array);
		
		for(int i = 0; i < array.length - 1; i++) {
			if(array[i] == array[i + 1]) {
				System.out.println("Duplicate Exists");
				return;
			}
		}
		System.out.println("Duplicate doesn't exists");
	}
	
	//O(n)
	//Only work for positive numbers
	//Only works for values that is between 0 and n - 1
	public void checkDuplicatesEfficient(int[] array) {
		
		for(int i = 0; i < array.length; i++) {
			
			if(array[Math.abs(array[i])] < 0) {
				System.out.println("Duplicate Exists");
				return;
			} else {
				array[Math.abs(array[i])] = - array[Math.abs(array[i])];	
			}
		}
		
		System.out.println("Duplicate doesn't exists");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		DuplicatesInArray obj = new DuplicatesInArray();
		//obj.checkDuplicates(new int[]{1,2,3,4,5});
		//obj.checkDuplicatesBySorting(new int[]{1,2,3,4,5,6,7,7,9});
		obj.checkDuplicatesEfficient(new int[]{0,1,2,3,4,5});
	}

}
