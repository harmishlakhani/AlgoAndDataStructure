package com.hackerrank.euler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class LargestPalindromeProduct {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		Set<Integer> set = new HashSet<Integer>();
		for(int i = 999; i > 99; i--) {
			for(int j = 999; j > 99; j--) {
				int number = i * j;
				if(isPalindrom(number)) {
					set.add(number);
				}
			}	
		}
		
		for (int a = 0; a < t; a++) {
			int n = Integer.parseInt(br.readLine());
			int max = Integer.MIN_VALUE;
			for(int temp : set) {
				if(temp < n && temp > max) {
					max = temp;
				}
			}
			System.out.println(max);
		}
	}
	
	public static boolean isPalindrom(int number) {
		
		int temp = 0;
		int tempNumber = number;
		while(tempNumber > 0) {
			temp = (temp * 10) + (tempNumber % 10);
			tempNumber = tempNumber / 10;
		}
		return number == temp;
	}
}