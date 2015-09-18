package com.hackerrank.booking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BookingA {

	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		int squares = 0;
		int rectangles = 0;
		int other = 0;
		
		for(int index = 0; index < t; index++) {
			
			String[] input = br.readLine().split(" ");
			int A = Integer.parseInt(input[0]);
			int B = Integer.parseInt(input[1]);
			int C = Integer.parseInt(input[2]);
			int D = Integer.parseInt(input[3]);
			
			if( A == B && B == C && C == D ) {
				squares++;
			}
			else if( A == C && B == D) {
				rectangles++;
			} else {
				other++;
			}
		}
		
		System.out.println(squares + " " + rectangles + " " + other);
	}
}