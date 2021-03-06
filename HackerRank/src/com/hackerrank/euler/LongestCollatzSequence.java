package com.hackerrank.euler;
/**
 * http://www.mathblog.dk/project-euler-14/
 * http://www.helptouser.com/codereview/91843-project-euler-14-in-java.html
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestCollatzSequence {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int SIZE = 5000001;
		int[][] hash = new int[SIZE + 1][2];
		int[] dp = new int[SIZE + 1];
		
		hash[1][0] = 1;
		hash[1][1] = 1;
		dp[1] = 1;

		for (int i = 2; i <= SIZE; i++) {

			long temp = i;
			int count = 1;

			while (temp != 1) {
				if(temp <= SIZE && dp[(int) temp] != 0) {
					count = count + dp[(int) temp];
					count--;
					break;
				}
				if (temp % 2 == 0) {
					temp = (long) temp / 2;
				} else {
					temp = (long) 3 * temp + 1;
				}
				count++;
			}
			dp[i] = count;
			
			if (dp[i] > hash[i - 1][1]) {
				hash[i][1] = count;
				hash[i][0] = i;
			} else if (dp[i] == hash[i - 1][1]) {
				hash[i][0] = Math.max(hash[i - 1][0], i);
				hash[i][1] = hash[i - 1][1];
			} else {
				hash[i][0] = hash[i - 1][0];
				hash[i][1] = hash[i - 1][1];
			}
		}

		int t = Integer.parseInt(br.readLine());
		for (int a = 0; a < t; a++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(hash[n][0]);
		}
	}
}