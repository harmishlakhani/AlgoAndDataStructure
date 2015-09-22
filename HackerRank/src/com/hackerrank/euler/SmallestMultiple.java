package com.hackerrank.euler;

/**
 * http://codereview.stackexchange.com/questions/13086/smallest-multiple
 * http://www.mathblog.dk/project-euler-problem-5/
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SmallestMultiple {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int a = 0; a < t; a++) {
			int n = Integer.parseInt(br.readLine());

			//Brute Force
			/*for (int number = 1;; number++) {
				int i = 1;
				for (i = 1; i <= n; i++) {
					if (number % i != 0)
						break;
				}
				if(i == n + 1) {
					System.out.println(number);
					break;
				}
			}*/
			
			
			Map<Integer, Integer> maxMap = new HashMap<Integer, Integer>();
			for(int i = 1; i <= n; i++) {
				Map<Integer, Integer> map = primeFactorization(i);
				
				for(int key : map.keySet()) {
					if(!maxMap.containsKey(key)) {
						maxMap.put(key, map.get(key));
					}
					else if(map.get(key) > maxMap.get(key)) {
						maxMap.put(key, map.get(key));
					}
				}
			}
			
			long answer = 1;
			for(int key : maxMap.keySet()){
				answer = answer * (long)Math.pow(key, maxMap.get(key));
			}
			System.out.println(answer);
		}
	}
	
	public static Map<Integer, Integer> primeFactorization(int number) {
		
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
}