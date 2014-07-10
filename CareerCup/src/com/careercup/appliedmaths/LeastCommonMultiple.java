package com.careercup.appliedmaths;

import java.util.HashMap;
import java.util.Map;

public class LeastCommonMultiple {

	public int leastCommonMultiple(int x, int y) {
		
		//Map<Integer, Integer> mapX = primeFactors(x);
		//Map<Integer, Integer> mapY = primeFactors(y);
		
		int prime = 2;
		int countX = 0;		
		int countY = 0;
		int lcm = 1;
		
		while(!(x == 1 && y == 1)) {
			
			countX = 0;
			while(x % prime == 0) {
				x /= prime;
				countX++;
			}
			
			countY = 0;
			while(y % prime == 0) {
				y /= prime;
				countY++;
			}
			
			lcm *= Math.pow(prime, Math.max(countX, countY));
			prime++;
		}

		//System.out.println(mapX);
		//System.out.println(mapY);
		
		System.out.println(lcm);
		return lcm;
	}
	
	private Map<Integer, Integer> primeFactors(int x) {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int prime = 2;
		int count = 0;
		
		while(x != 1) {
			
			count = 0;
			while(x % prime == 0) {
				x /= prime;
				count++;
			}
			map.put(prime, count);
			prime++;
		}
		return map;
	}
	
	public static void main(String args[]) {
		
		LeastCommonMultiple obj = new LeastCommonMultiple();
		obj.leastCommonMultiple(16, 8);
	}
}
