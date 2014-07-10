package com.topcoder.srm.srm616;

import java.util.Arrays;

public class AmebaDiv2 {
	
	public int simulate(int[] X, int A) {
		
		int size = A;
		
		for(int i = 0; i < X.length; i++) {
			if(X[i] == size)
				size *= 2;
		}
		
		
		return size;
	}
				
	public static void main(String[] args) {

		AmebaDiv2 obj = new AmebaDiv2();
		
		System.out.println(obj.simulate(new int[] {2,1,3,1,2},1));
		
		
	}

}

