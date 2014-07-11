package com.topcoder.srm.srm624;

import java.util.Arrays;

public class CostOfDancing {
	
	public int minimum(int K, int[] danceCost) {
		
		Arrays.sort(danceCost);
		int total = 0;
		
		for(int i = 0; i < K; i++) {
			total += danceCost[i];
		}
		return total;
	}
				
	public static void main(String[] args) {

		CostOfDancing obj = new CostOfDancing();
		System.out.println(obj.minimum(0,new int[] {}));
	}

}
