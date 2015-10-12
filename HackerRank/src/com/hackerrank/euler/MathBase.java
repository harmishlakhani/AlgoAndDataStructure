package com.hackerrank.euler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MathBase {

	/**
	 * General factorization of number
	 * @param n
	 * @return
	 */
	public static Set<Integer> factorization(int n) {
		
		Set<Integer> set = new HashSet<Integer>();
		
		int temp = (int) Math.sqrt(n);
		for(int i = 1; i <= temp; i++) {
			if(n % i == 0) {
				set.add(i);
				set.add(n / i);
			}
		}
		
		return set;
	}
	
	/**
	 * This method is used to find prime factors of any input number
	 * @param number
	 * @return
	 */
	public Map<Integer, Integer> primeFactorization(int n) {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int factor = 1;
		
		while(true) {
			factor = 1;
			int sqrtN = (int) Math.sqrt(n);
			
			if (n % 2 == 0) {
				int count2 = 0;
				while (n % 2 == 0) {
					n = n / 2;
					count2++;
				}
				if(map.containsKey(2)) {
					map.put(2, map.get(2) + count2);
				} else {
					map.put(2, count2);
				}
			}
			
			//for even numbers
			if (n == 1) {
				break;
			}

			for (int i = 3; i <= sqrtN; i = i + 2) {
				int count = 0;
				if (n % i == 0) {
					while (n % i == 0) {
						n = n / i;
						count++;
					}
					if(map.containsKey(i)) {
						map.put(i, map.get(i) + count);
					} else {
						map.put(i, count);
					}
					factor = i;
				}
			}
			//for perfect squares like n = 25, n will become 1 after above loop
			if (n == 1) {
				break;
			}

			//when factor remains 1 it means n is prime so we will exit
			if(factor == 1) {
				map.put(n, 1);
				break;
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
	
	/**
	 * it will return multiplication of n and list and return same list
	 * list [3, 2, 1]    -> 123
	 * n                 -> 11
	 * ans  [3, 5, 3, 1] -> 1353  
	 * @param list
	 * @param n
	 * @return
	 */
	public static List<Integer> multiplication(List<Integer> list, int n) {
		
		
		int carry = 0;
		int size = list.size();
		
		for(int i = 0; i < size ; i++) {
			
			int temp = list.get(i) * n + carry;
			list.set(i, temp % 10);
			carry = temp / 10;
		}
		
		while(carry != 0) {
			list.add(carry % 10);
			carry = carry / 10;
		}
		
		return list;
	}
}
