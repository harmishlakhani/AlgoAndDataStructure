package com.hackerrank.euler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargestPrimeFactor {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int a = 0; a < t; a++) {
			long n = Long.parseLong(br.readLine());
			long factor = 1;
			
			while(true) {
				factor = 1;
				long sqrtN = (long) Math.sqrt(n);
				
				if (n % 2 == 0) {
					while (n % 2 == 0) {
						n = n / 2;
					}
				}
				if (n == 1) {
					factor = 2;
					break;
				}

				for (long i = 3; i <= sqrtN; i = i + 2) {
					if (n % i == 0) {
						while (n % i == 0) {
							n = n / i;
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
					factor = n;
					break;
				}
			}
			
			System.out.println(factor);
		}
	}
}