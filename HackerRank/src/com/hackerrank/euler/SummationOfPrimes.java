package com.hackerrank.euler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SummationOfPrimes {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		List<Integer> list = getPrimes(1000000);
		
		for (int a = 0; a < t; a++) {
			int n = Integer.parseInt(br.readLine());
			long total = 0;
			for(int temp : list) {
				if(temp > n) {
					break;
				}
				total += temp;
			}
			System.out.println(total);
		}
	}
	
	public static List<Integer> getPrimes(int SIZE) {

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

		return list;
	}
}