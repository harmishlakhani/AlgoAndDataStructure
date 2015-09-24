package com.hackerrank.euler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargestProductInSeries {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int a = 0; a < t; a++) {
			String[] in = br.readLine().split(" ");
			
			int N = Integer.parseInt(in[0]);
			int K = Integer.parseInt(in[1]);
			
			String number = br.readLine();
			
			long baseProduct = 1; 
			for(int i = 0; i < K; i++) {
				baseProduct *= (long)(number.charAt(i) - 48);
			}
			
			long maxProduct = baseProduct;
			for(int i = K; i < N; i++) {
				long digit = number.charAt(i) - 48;
				long digitTemp = number.charAt(i - K) - 48;
				
				if(digitTemp != 0) {
					baseProduct = baseProduct / digitTemp * digit;
				} else {
					baseProduct = 1;
					for(int j = i ; j > i - K; j--) {
						baseProduct *= (long)(number.charAt(j) - 48);
					}
				}
				
				if(baseProduct >= maxProduct)
					maxProduct = baseProduct;
			}
			System.out.println(maxProduct);

		}
	}
}