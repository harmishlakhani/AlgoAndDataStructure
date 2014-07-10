package com.topcoder.srm.srm620;

import java.util.HashSet;
import java.util.Set;

public class GoodCompanyDivTwo {
	
	public int countGood(int[] superior, int[] workType) {
		
		int N = superior.length;
		Set<Integer> set = null;
		int noOfSet = 0;
		
		for(int i = 0 ; i < N; i++) {
			int count = 1;
			set = new HashSet<Integer>();
			set.add(workType[i]);
			for(int j = i + 1 ; j < N; j++) {
				if(superior[j] == i) {
					set.add(workType[j]);
					count++;
				}
			}
			if(count == set.size())
				noOfSet++;
		}
		return noOfSet;
	}
				
	
	public static void main(String[] args) {

		GoodCompanyDivTwo obj = new GoodCompanyDivTwo();
		 
		System.out.println(obj.countGood(new int[] {-1, 0, 0, 1, 1, 3, 0, 2, 0, 5, 2, 5, 5, 6, 1, 2, 11, 12, 10, 4, 7, 16, 10, 9, 12, 18, 15, 23, 20, 7, 4},new int[] {4, 6, 4, 7, 7, 1, 2, 8, 1, 7, 2, 4, 2, 9, 11, 1, 10, 11, 4, 6, 11, 7, 2, 8, 9, 9, 10, 10, 9, 8, 8}));
		
		
	}

}

