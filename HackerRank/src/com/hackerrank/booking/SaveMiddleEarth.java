package com.hackerrank.booking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SaveMiddleEarth {

	public static int find(String input, int n) {
		
		int count = 0;
		char current = 'a';
		char next = ' ';
		int length = input.length();
		
		int start1 = 26 - (26 % n) + 1;
		int end1 = 26;
		
		int start2 = 26 - n;
		int end2 = start1 - 1;
		
		for (int i = 0; i < length; i++) {
			next = input.charAt(i);
			
			int a = (((int)current) - 96);
			int b = (((int)next) - 96);
			
			if (((start1 <= a && a <= end1) && (start2 <= b && b <= end2)) ) {
				a = a - n;
				count += Math.abs(a - b);
				count++;
			} else if ((start1 <= b && b <= end1) && (start2 <= a && a <= end2)) {
				b = b - n;
				count += Math.abs(a - b);
				count++;
			} else {
				int diff = Math.abs(current - next);
				count += diff / n;
				count += diff % n; 
			}
			current = next;
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int index = 0; index < t; index++) { 
			
			String in[] = br.readLine().split(" ");
			
			int n = Integer.parseInt(in[0]);
			int Q = Integer.parseInt(in[1]);
			
			for(int k = 0; k < Q; k++) {
				System.out.println(find(br.readLine(), n));
			}
		}
	}
}