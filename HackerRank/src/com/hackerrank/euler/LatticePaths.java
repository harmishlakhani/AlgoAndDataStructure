package com.hackerrank.euler;

/**
 * http://www.mathblog.dk/project-euler-15/
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LatticePaths {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int MOD = 1000000007;
		int SIZE  = 502;
		long[][] hash = new long[SIZE][SIZE];
		
		for(int i = 1; i < SIZE - 1; i++) {
			hash[1][i] = 1;
		}
		
		for(int i = 1; i < SIZE - 1; i++) {
			hash[i][1] = 1;
		}
		
		for(int i = 2; i < SIZE - 1; i++) {
			for(int j = 2; j < SIZE - 1; j++) {
				hash[i][j] = (hash[i - 1][j] + hash[i][j - 1]) % MOD;
			}	
		}
		
		int t = Integer.parseInt(br.readLine());
		for(int a = 0; a < t; a++) {
			String in[] = br.readLine().split(" ");
			int N = Integer.parseInt(in[0]);
			int M = Integer.parseInt(in[1]);
			System.out.println(hash[N + 1][M + 1]);
		}
	}
	
}