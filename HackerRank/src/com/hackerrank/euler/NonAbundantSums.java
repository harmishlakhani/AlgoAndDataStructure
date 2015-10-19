package com.hackerrank.euler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NonAbundantSums {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int SIZE = 100000;
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 1; i <= SIZE; i++) {
			int total = factorization(i);
			if (total > i)
				list.add(i);
		}

		Collections.sort(list);
		//System.out.println(list);
		int t = Integer.parseInt(br.readLine());

		outer: for (int a = 0; a < t; a++) {

			int n = Integer.parseInt(br.readLine());

			for (int no : list) {
				if (no < n) {
					if (list.contains(n - no)) {
						System.out.println("YES");
						continue outer;
					}
				}
			}
			System.out.println("NO");
		}
	}

	public static int factorization(int n) {

		int temp = (int) Math.sqrt(n);
		int total = 0;
		for (int i = 1; i <= temp; i++) {
			if (n % i == 0) {
				if (i * i != n) {
					total = total + i + (n / i);
				} else {
					total = total + i;
				}
			}
		}
		total = total - n;
		return total;
	}

}