package com.ds.search;

import java.util.Arrays;

public class FirstDuplicateInArray {

	//O(n2)
	public void firstDuplicate(int[] array) {
		
		for(int i = 0; i < array.length; i++) {
			for(int j = i + 1; j < array.length; j++) {
				
				if(array[i] == array[j]) {
					System.out.println("First Duplicate is " + array[i]);
					return;
				}
			}
		}
		System.out.println("Duplicate doesn't exists");
	}
	
	//O(n) + space : O(n)
	public void firstDuplicateByHashing(int[] array) {
		
		int hashSize = Integer.MIN_VALUE;
		int firstRepeat = Integer.MIN_VALUE;
		
		for(int i = 0; i < array.length; i++) {
			if(hashSize < array[i])
				hashSize = array[i];
		}
		
		int[] hash = new int[hashSize + 1];
		
		for(int i = 0; i < array.length; i++) {
			if(hash[array[i]] > 0) 
				hash[array[i]] = -(i + 1);
			else if(hash[array[i]] < 0)
				continue;
			else
				hash[array[i]] = i + 1;
		}
		
		for(int i = 0; i < hashSize + 1; i++) {
			if(hash[i] < 0 && firstRepeat < hash[i])
				firstRepeat = i;
		}
		
		System.out.println("First Duplicate is " + firstRepeat);
		
	}
	
	
	public static void main(String[] args) {

		FirstDuplicateInArray obj = new FirstDuplicateInArray();
		obj.firstDuplicate(new int[]{1,2,3,4,5,5});
		obj.firstDuplicateByHashing(new int[]{1,2,3,4,4,4,5,6,7,7,9,2,2});
	}

}
