package com.careercup.appliedmaths;

import java.util.TreeMap;

public class KthNoWithPrimeFact357Only {

	public int getKthNumber(int x) {
		
		int k = 0;
		
		for(int i = 1; ; i++) {
			
			int j = i;
			
			while(j % 3 == 0) {
				j = j/3;
			}
			
			while(j % 5 == 0) {
				j = j/5;
			}
			
			while(j % 7 == 0) {
				j = j/7;
			}
				
			if(j == 1) {
				k++;
				if(k == x)
					return i;
			}
		}
	}
	
	public int getKthNumberOptimized(int x) {
		
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		map.put(1,1);
		int key = 1;
		while(x != 0) {
			key = map.firstKey();
			map.remove(key);
			map.put(key * 3, 1);
			map.put(key * 5, 1);
			map.put(key * 7, 1);
			x--;
		}
		
		return key;
	}
	
	public static void main(String args[]) {
		
		KthNoWithPrimeFact357Only obj = new KthNoWithPrimeFact357Only();
		System.out.println(obj.getKthNumberOptimized(1000));
		//System.out.println(obj.getKthNumber(500));
		
	}
}
