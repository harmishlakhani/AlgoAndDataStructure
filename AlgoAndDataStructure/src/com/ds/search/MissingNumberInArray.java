package com.ds.search;


public class MissingNumberInArray {

	//O(n2)
	public void missingNumber(int[] array, int n) {
		
		for(int i = 1; i < n; i++) {
			
			boolean flag = false;
			for(int j = 0; j < array.length; j++) {
				 if(i == array[j]) {
					flag = true;
				}
			}
			
			if(!flag) {
				System.out.println("Missing Number is : " + i);
				return;
			}		
		}
	}
	
	//O(n) + space : O(n)
	public void missingNumberByHashing(int[] array, int n) {
		
		int[] hash = new int[n + 1];
		
		for(int i = 0; i < array.length; i++) {
			hash[array[i]] = 1;
		}
		
		for(int i = 1; i <= n; i++) {
			if(hash[i] == 0) {
				System.out.println("Missing Number is : " + i);
				return;
			}
		}
		
	}
	
	//O(n)
	public void missingNumberEfficient(int[] array, int n) {
		
		int sum = 0;
		int number = -1;
		
		for(int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		
		number = (n * (n + 1) / 2) - sum;
		System.out.println("Missing Number is : " + number);
	}
	
	//O(n)
	//to avoid overflow
	public void missingNumberEfficient2(int[] array, int n) {
		
		int X = 0;
		int Y = 0;
		
		for(int i = 0; i < array.length; i++) {
			X ^= array[i];
		}
		
		for(int i = 1; i <= n; i++) {
			Y ^= i;
		}
		
		System.out.println("Missing Number is : " + (X ^ Y));
	}
	
	public static void main(String[] args) {

		MissingNumberInArray obj = new MissingNumberInArray();
		obj.missingNumber(new int[]{1,2,3,5}, 5);
		obj.missingNumberByHashing(new int[]{1,2,3,4,5,6,8,9},9);
		obj.missingNumberEfficient(new int[]{1,2,3,4,5,6,7,8},9);
		obj.missingNumberEfficient2(new int[]{1,2,3,4,5,6,7,8},9);
	}

}
