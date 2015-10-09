package com.hackerrank.euler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumPathSumI {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for (int a = 0; a < t; a++) {

			int n = Integer.parseInt(br.readLine());
			int array[][] = new int[n + 1][n + 1];
			int dp[][] = new int[n + 1][n + 1];
			
			for(int i = 1; i <= n; i++) {
				String in[] = br.readLine().split(" ");
				for(int j = 1; j <= i; j++) {
					array[i][j] = Integer.parseInt(in[j - 1]);
				}
			}

			dp[1][1] = array[1][1];
			
			for(int i = 2; i <= n; i++) {
				for(int j = 1; j <= i; j++) {
					dp[i][j] = Math.max((array[i][j] + dp[i - 1][j]), (array[i][j] + dp[i - 1][j - 1]));
				}
			}

			int max = Integer.MIN_VALUE;
			for(int i = 1; i <= n; i++) {
				if(max < dp[n][i])
					max = dp[n][i];
			}
			System.out.println(max);
		}
	}
}