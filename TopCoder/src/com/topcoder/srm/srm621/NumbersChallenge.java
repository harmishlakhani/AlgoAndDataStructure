package com.topcoder.srm.srm621;

import java.util.Arrays;


public class NumbersChallenge {
	
	public int MinNumber(int[] S) {
		
		Arrays.sort(S);
		int length = S.length;
		
		for(int i = 1; ;i++) {
			
			int temp = i;
			int index = length - 1;
			
			for(int j = 0; j < length; j++) {
				if(S[j] >= i) {
					index = j;
					break;
				}
			}
				
			while(index >= 0 && temp > 0) {
				if(temp >= S[index])
					temp = temp - S[index];
				index--;
			}
			
			if(temp != 0)
				return i;
		}
		
	}
				
	
	public static void main(String[] args) {

		NumbersChallenge obj = new NumbersChallenge();
		 
		System.out.println(obj.MinNumber(new int[] {883, 66392, 3531, 28257, 1, 14131, 57, 1, 25, 88474, 4, 1, 110, 6, 1769, 220, 442, 7064, 7, 13}));
		
		
	}

}

