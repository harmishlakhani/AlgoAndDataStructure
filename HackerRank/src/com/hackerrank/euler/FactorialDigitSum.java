package com.hackerrank.euler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FactorialDigitSum {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int a = 0; a < t; a++) {
			int n = Integer.parseInt(br.readLine());
			
			List<Integer> list = new ArrayList<Integer>(); 
			list.add(1);
			
			for(int i = 1; i <= n; i++) {
				list = multiplication(list, i);
			}
			
			int total = 0;
			for(int x : list)
				total += x;
			System.out.println(total);
		}
	}
	
	public static List<Integer> multiplication(List<Integer> list, int n) {
		
		
		int carry = 0;
		int size = list.size();
		
		for(int i = 0; i < size ; i++) {
			
			int temp = list.get(i) * n + carry;
			list.set(i, temp % 10);
			carry = temp / 10;
		}
		
		while(carry != 0) {
			list.add(carry % 10);
			carry = carry / 10;
		}
		
		return list;
	}
}