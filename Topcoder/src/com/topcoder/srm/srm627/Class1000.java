package com.topcoder.srm.srm627;


public class Class1000 {

	public int findSum(int[] array) {

		int size = array.length;
		int total = 0;
		
		for(int i = 1; i <= size; i++) {
			
			for(int k = 0; k < size; k++) {
			
				for(int j = k; (k + i) <= size && j < k + i; j++) {
					total += array[j];
				}
				
			}
			
		}
		
		return total;
	}

	public static void main(String[] args) {

		Class1000 obj = new Class1000();

		System.out.println(obj.findSum(new int[] {1,2,3,4,5,6,7,8,9,10}));
	}

}
