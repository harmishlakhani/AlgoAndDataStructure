package com.hackerrank.euler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MathBase {

	/**
	 * This method is used to find prime factors of any input number
	 * @param number
	 * @return
	 */
	public Map<Integer, Integer> primeFactorization(int number) {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int count2 = 0;
		while(number % 2 == 0) {
			number = number / 2;
			count2++;
		}
		map.put(2, count2);
		
		for(int i = 3; i <= number; i = i + 1) {
			if(number % i == 0) {
				int count = 0;
				while(number % i == 0) {
					number = number / i;
					count++;
				}
				map.put(i, count);
			}
		}
		
		return map;
	}

	/**
	 * This method is used to find first SIZE prime numbers
	 * 
	 * @param SIZE
	 * @return List<Integer>
	 */
	public List<Integer> getPrimes(int SIZE) {

		int[][] primeStore = new int[SIZE][2];
		List<Integer> list = new ArrayList<Integer>();

		primeStore[0][0] = 2;
		int k = 3;

		for (int i = 1; i < SIZE; i++) {
			primeStore[i][0] = k;
			k = k + 2;
		}

		int prime = 3;
		int primeIndex = 1;
		while (true) {
			// find prime to cross out its multiples
			for (int i = primeIndex; i < SIZE; i++) {
				if (primeStore[i][1] == 0) {
					prime = primeStore[i][0];
					primeIndex = i + 1;
					break;
				}
			}

			int primeSquare = prime * prime;
			if (primeSquare > primeStore[SIZE - 1][0])
				break;

			for (int i = primeIndex; i < SIZE; i++) {
				if ((primeStore[i][0] % prime == 0) && primeStore[i][1] == 0) {
					primeStore[i][1] = 1;
				}
			}

		}

		for (int i = 0; i < SIZE; i++) {
			if (primeStore[i][1] == 0) {
				list.add(primeStore[i][0]);
			}
		}

		/*
		 * for(int a : list) { System.out.println(a); }
		 */
		return list;
	}
}
