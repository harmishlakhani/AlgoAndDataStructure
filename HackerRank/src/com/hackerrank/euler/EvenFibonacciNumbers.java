package com.hackerrank.euler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EvenFibonacciNumbers {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int a = 0; a < t; a++) {
			long n = Long.parseLong(br.readLine());
			long even = 2;
			long first = 1;
			long second = 2;
			long fibb = 0;
			
			while(second + first < n) {
				fibb = second + first;
				first = second;
				second = fibb;
				if(fibb % 2 == 0)
					even += fibb;
			}
			System.out.println(even);
		}
		}
}