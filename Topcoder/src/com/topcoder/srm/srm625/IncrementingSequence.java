package com.topcoder.srm.srm625;

import java.util.Arrays;


public class IncrementingSequence {
	
	public String canItBeDone(int k, int[] A) {
		
		Arrays.sort(A);
		int length = A.length;
		int[] array = new int[length];
		boolean flag = false;
		
		for(int i = 1; i <= length; i++) {
			
			flag = true;
			for(int j = 0; j < length; j++) {
				if(A[j] == i) {
					array[j] = 1;
					flag = false;
					break;
				} 
			}
			
			if(flag) {
				for(int j = 0; j < length; j++) {
					for(int a = 0; a < length; a++) { 
						if(array[a] == 0 && (i - A[a]) % k == 0) {
							array[a] = 1;
							break;
						}
					}
				}
			}
			
		}
		
		int temp = 1;
		for(int i = 0; i < length; i++)
			temp = temp * array[i];
		if(temp == 0)
			return "IMPOSSIBLE";
		else 
			return "POSSIBLE";
	}
				
	public static void main(String[] args) {

		IncrementingSequence obj = new IncrementingSequence();
		System.out.println(obj.canItBeDone(2,new int[] {5,3,3,2,1}));
	}

}
