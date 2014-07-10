package com.maths;

import java.util.HashMap;
import java.util.Map;

public class PrimeNumber {

	public boolean isPrime(int number) {
		
		if(number < 2) {
			System.out.println("Not a valid number");
			return false;
		}
		else if(number == 2)
			return true;
		
		int count = 0;
		for(int i = 2; i < Math.sqrt(number); i++) {
			if(number % i == 0) {
				number = number / i;
				count++;
			}			
		}
		return count == 0 ? true : false;
	}
	
	public Map<Integer, Integer> primeFactorization(int number) {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 2; i <= number; i++) {
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
	
	public String isDivisible(int A, int B, int C, int D) {
		
		Map<Integer, Integer> primeFactorsA = primeFactorization(A);
		Map<Integer, Integer> primeFactorsC = primeFactorization(C);
		
		for(int a : primeFactorsC.keySet()) {
			if(primeFactorsC.get(a) * D > primeFactorsA.get(a) * B)
				return "not divisible";
		}
		return "divisible";
		
	}
	public static void main(String[] args) {
		
		PrimeNumber obj = new PrimeNumber();
		System.out.println(obj.isPrime(1));
		System.out.println(obj.primeFactorization(121212));
		System.out.println(obj.isDivisible(10000, 9000000, 200, 9000000));

	}

}
