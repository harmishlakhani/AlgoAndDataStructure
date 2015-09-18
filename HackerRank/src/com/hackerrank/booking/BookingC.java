package com.hackerrank.booking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BookingC {

	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		System.out.print(input[0] + " ");
		
		if(input.length > 1) {
			for(int i = 1; i < input.length; i++) {
				int diff = Integer.parseInt(input[i]) - Integer.parseInt(input[i - 1]);
				if (!(diff <= 127 && diff >= -127)) {
					System.out.print(-128 + " ");
				}
				System.out.print(diff + " ");
			}
		}
	}
}