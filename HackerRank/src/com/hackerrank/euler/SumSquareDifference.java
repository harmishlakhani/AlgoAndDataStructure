package com.hackerrank.euler;

/**
 * http://www.mathblog.dk/project-euler-problem-6/
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumSquareDifference {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int a = 0; a < t; a++) {
			int n = Integer.parseInt(br.readLine());
			
			long diff = 0;
			long totalSum = n * (n + 1) / 2;
			for(int i = 1; i <= n; i++) {
				diff += (long)i * (totalSum - i);
			}
			System.out.println(diff);
		}
	}
}