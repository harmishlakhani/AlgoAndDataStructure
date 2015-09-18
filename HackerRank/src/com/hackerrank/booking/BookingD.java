package com.hackerrank.booking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


public class BookingD {

	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i = 0; i < M; i++) {
			int element = Integer.parseInt(br.readLine());
			int diff = Math.abs(element - N);
			if(set.contains(diff)) {
				System.out.println(1);
				return;
			} else {
				set.add(diff);
				set.add(element);
			}
		}
		System.out.println(0);
	}
}