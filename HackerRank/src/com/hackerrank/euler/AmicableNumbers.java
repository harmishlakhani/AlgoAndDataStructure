package com.hackerrank.euler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AmicableNumbers {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int SIZE = 100001;
		int[] hash = new int[SIZE];
		
		for(int i = 1; i < SIZE; i++) {
			hash[i] = factorization(i);
		}
		
		int t = Integer.parseInt(br.readLine());

		for (int a = 0; a < t; a++) {

			int n = Integer.parseInt(br.readLine());
			Set<Integer> op = new HashSet<Integer>();

			for (int i = 1; i <= n; i++) {
				
				if(op.contains(i))
					continue;
				
				int total = hash[i];
				int total2 = 0;
				if(total > SIZE -1) {
					total2 = factorization(total);
				} else {
					total2 = hash[total];
				}

				if (total2 == i && i != total) {
					op.add(i);
					op.add(total);
				}
			}
			int count = 0;
			for (int y : op) {
				if(y <= n) {
				count += y;
				}
			}
			System.out.println(count);
		}
	}

	public static int factorization(int n) {

		int temp = (int) Math.sqrt(n);
		int total = 0;
		for (int i = 1; i <= temp; i++) {
			if (n % i == 0) {
				total = total + i + (n / i);
			}
		}
		total = total - n;
		return total;
	}

}