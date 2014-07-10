package com.topcoder.srm.srm627;

import java.util.Arrays;

public class Class250 {
	
	public int howManySquares(int[] sticks) {
		
		Arrays.sort(sticks);
		int count = 0;

		for(int i = 0; i < sticks.length;) {
			int temp = 1;
			while(i + 1 < sticks.length && sticks[i] == sticks[i + 1]) {
				temp++;
				i++;
			}
			count += temp / 4;
			i++;
		}
		return count;
	}
				
	public static void main(String[] args) {

		Class250 obj = new Class250();
		System.out.println(obj.howManySquares(new int[] {1,1,2,2,1,1,2}));
	}

}
