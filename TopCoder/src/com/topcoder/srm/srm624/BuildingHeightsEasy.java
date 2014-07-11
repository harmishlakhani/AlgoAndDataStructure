package com.topcoder.srm.srm624;

import java.util.Arrays;

public class BuildingHeightsEasy {

	public int minimum(int M, int[] heights) {

		Arrays.sort(heights);	
		int min = Integer.MAX_VALUE;
		
		for(int i = M - 1; i < heights.length; i++) {
		
			int count = 0;
			int j = i, temp = 0;
			while(count < M) {
				temp += heights[i] - heights[j];
				count++;
				j--;
			}
			if(temp < min)
				min = temp;
		}
		
		return min;
	}

	public static void main(String[] args) {

		BuildingHeightsEasy obj = new BuildingHeightsEasy();

		System.out.println(obj.minimum(12, new int[] {25, 18, 38, 1, 42, 41, 14, 16, 19, 46, 42, 39, 38, 31, 43, 37, 26, 41, 33, 37, 45, 27, 19, 24, 33, 11, 22, 20, 36, 4, 4}));

	}

}
