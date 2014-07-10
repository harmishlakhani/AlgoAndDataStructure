package com.geeksforgeeks.amazon;

import java.util.Arrays;

public class SmallestNumberUsingSameDigit {

	public static String smallestNumberUsingSameDigit(String number) {
		
		char array[] = number.toCharArray();
		int length = array.length;
		int index = length - 1;
		
		for(; index > 0; index--) {
			if(array[index] > array[index - 1])
				break;
		}
		
		if(index == 0)
			return "-1";
		
		char tempArray[] = Arrays.copyOfRange(array, index - 1, length);
		Arrays.sort(tempArray);
		char temp = array[index - 1];
		boolean flag = false;
		int tempIndex = 0;
		
		for(int i = 0; i < tempArray.length; i++) {
			if(temp < tempArray[i] && !flag) {
				array[index - 1] = tempArray[i];
				flag = true;
				continue;
			} else {
				array[index + tempIndex] = tempArray[i];
				tempIndex++;
			}
		}
		
		return new String(array);
	}
	
	public static void main(String args[]) {
		System.out.println(smallestNumberUsingSameDigit("123456784987654321"));
	}
	
}
