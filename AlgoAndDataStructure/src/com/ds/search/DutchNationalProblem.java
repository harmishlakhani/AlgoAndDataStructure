package com.ds.search;

public class DutchNationalProblem {

	public static void sort(int[] array) {
		
		int left = 0;
		int mid = 0;
		int right = array.length - 1;
		
		while(mid <= right) {
			
			if(array[mid] == 0) {
				array[mid] = array[left];
				array[left] = 0;
				left++;
				mid++;
			}
			
			else if(array[mid] == 1)
				mid++;
			else {
			//if(array[mid] == 2) {
				array[mid] = array[right];
				array[right] = 2;
				right--;
			}
		}
	}

	public static void print(int[] array) {
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
	}
	
	public static void main(String[] args) {
		
		int[] array = new int[]{1, 0, 0, 2, 2, 0, 1, 1, 0};
		sort(array);
		print(array);

	}

}
