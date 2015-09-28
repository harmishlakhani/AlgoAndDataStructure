package com.hackerrank.euler;
/**
 * http://codereview.stackexchange.com/questions/83579/project-euler-problem-12-in-python
 * http://www.mathblog.dk/triangle-number-with-more-than-500-divisors/
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class HighlyDivisibleTriangularNumber {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for(int a = 0; a < t; a++) {
			int n = Integer.parseInt(br.readLine());
			
			int number = 1;
			while(true) {
				
				int triangle = (int) (number * (number + 1) / 2);
				int count = 0;
				
				if(number % 2 == 0) {
					Set<Integer> set1 = factorization(number / 2);
					Set<Integer> set2 = factorization(number + 1);
					count = set1.size() * set2.size();
				} else {
					Set<Integer> set1 = factorization((number + 1) / 2);
					Set<Integer> set2 = factorization(number);
					count = set1.size() * set2.size();	
				}
				if(count > n) {
					System.out.println(triangle);
					break;
				}
				number++;	
			}
		}
		

	}

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
}