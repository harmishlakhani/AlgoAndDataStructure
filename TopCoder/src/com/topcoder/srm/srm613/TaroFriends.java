package com.topcoder.srm.srm613;

import java.util.Arrays;

public class TaroFriends {
	
	public int getNumber(int[] coordinates, int X) {
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int temp = 0;
		
		for(int i = 0; i < coordinates.length; i++) {
			
			if(coordinates[i] < 0) {
				temp = coordinates[i] + X;
			} else if (coordinates[i] >= 0) {
				temp = coordinates[i] - X;
			} /*else
				temp = 0;*/
			
			if(min > temp)
				min = temp;
			
			if(max < temp)
				max = temp;
		}
		System.out.println(min + " " + max);
		return max - min;
	}
				
	public static void main(String[] args) {

		TaroFriends obj = new TaroFriends();
		
		System.out.println(obj.getNumber(new int[] {7}, 0));
		
		
	}

}

