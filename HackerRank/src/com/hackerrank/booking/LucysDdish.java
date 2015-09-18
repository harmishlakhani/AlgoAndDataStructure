package com.hackerrank.booking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class LucysDdish {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] in = br.readLine().split(" ");
		
		int[] array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(in[i]);
		}
		
		int[] hash = new int[1001];
		
		for(int i = 0; i < N; i++) {
			hash[array[i]]++;
		}
		
		int maxCount = 0;
		int maxIndex = 1;
		int max = Integer.MIN_VALUE;
		
		for(int i = 1; i <= 1000; i++) {
			if(hash[i] > max) {
				max = hash[i];
				maxIndex = i;
				maxCount = 1;
			} else if(hash[i] == max) {
				maxCount++;
			}
		}
		
		System.out.println(maxCount == 1 ? maxIndex : -1);
	}
}