package com.hackerrank.booking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class TeamFormation {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int index = 0; index < t; index++) { 
			
			String in[] = br.readLine().split(" ");
			
			int n = Integer.parseInt(in[0]);
			if(n == 0 || n == 1) {
				System.out.println(n);
				continue;
			}
			int[] array = new int[n];
			for(int i = 1; i <= n; i++) {
				array[i  - 1] = Integer.parseInt(in[i]);
			}
			
			Arrays.sort(array);
			int length = array.length; 
			int min = Integer.MAX_VALUE;
			for(int i = 0; i <= length - 1; i++) {
				int count = 1;
				while(((i + 1) <= (length - 1)) && Math.abs(array[i] - array[i + 1]) == 1) {
					count++;
					i++;
				}
				if(min > count)
					min = count;
			}
			System.out.println(min);
		}
	}
}