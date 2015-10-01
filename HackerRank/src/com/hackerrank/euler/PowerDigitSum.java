package com.hackerrank.euler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class PowerDigitSum {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int a = 0; a < t; a++) {
			int n = Integer.parseInt(br.readLine());
			
			BigInteger num = new BigInteger("2");
			num = num.pow(n);
			String number = num.toString();

			int total = 0;
			for(int i = 0; i < number.length(); i++) {
				total += number.charAt(i) - 48;
			}
			System.out.println(total);
		}
	}
}