package com.ds.search;

import java.util.Arrays;

import com.ds.recursion.*;

public class TwoElementSumInArray {

	//O(n2)
	public void twoElementSum(int[] array, int k) {
		
		for(int i = 0; i < array.length; i++) {
			for(int j = i; j < array.length; j++) {
				if(array[i] + array[j] == k) {
					System.out.println("One is " + array[i] + " : Other is " + array[j]);
					return;
				}
			}
		}
		
		System.out.println("No such element");
	}
	
	//O(nlogn)
	public void twoElementSumBySorting(int[] array, int k) {
		
		Arrays.sort(array);
		
		for(int i = 0, j = array.length - 1; i < j;) {
			
			int temp = array[i] + array[j];
			
			if(temp == k) {
				System.out.println("One is " + array[i] + " : Other is " + array[j]);
				return;
			}
			else if(temp > k)
				j--;
			else 
				i++;
		}		
	}
	
	//O(n)
	public void twoElementSumByHashing(int[] array, int k) {
		
		int[] hash = new int[100];
		for(int i = 0; i < array.length; i++) {
			hash[array[i]] = 1;
			if(hash[k - array[i]] == 1) {
				System.out.println("One is " + array[i] + " : Other is " + (k - array[i]));
				return;
			}
		}		
		
		System.out.println("No such element");
	}
	
	//O(n)
	public void twoElementSquareSum(int[] array) {
		
		Arrays.sort(array);
		int[] squareArray = new int[array.length];
		
		for(int i = 0; i < array.length; i++) {
			squareArray[i] = array[i] * array[i];
		}
		
		for(int k = 0; k < squareArray.length; k++) {
			
			for(int i = 0, j = k; i < j;) {
				
				int temp = squareArray[i] + squareArray[j];
				
				if(temp == squareArray[k]) {
					System.out.println("One is " + array[i] + " : Other is " + array[j] + " : Square is " + array[k]);
					return;
				}
				else if(temp > squareArray[k])
					j--;
				else 
					i++;
			}		
		}		
		
		System.out.println("No such element");
	}
	
	public static void main(String[] args) {

		TwoElementSumInArray obj = new TwoElementSumInArray();
		obj.twoElementSum(new int[]{1,2,3,4,5}, 7);
		obj.twoElementSumBySorting(new int[]{3,4,5,1,2,10,15}, 12);
		obj.twoElementSumByHashing(new int[]{3,4,5,1,2,10,15}, 12);
		obj.twoElementSquareSum(new int[]{1,2,3,4,5});
	}

}
