package com.dp;

public class BinomialCoefficient {

	public int findCoefficientRec(int n, int k) {
		
		if(k == 0 || n == k)
			return 1;
		
		return findCoefficientRec(n - 1, k - 1) + findCoefficientRec(n - 1, k);
	}
	
	public int findCoefficientTabulation(int n, int k) {
		
		int[][] dp = new int[n + 1][k + 1];
		
		for(int i = 0; i <= n; i++) {
		
			for(int j = 0; j <= Math.min(i, k); j++) {
				if(j == 0 || i == j)
					dp[i][j] = 1;
				else
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}
		
		
		return dp[n][k];
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BinomialCoefficient obj = new BinomialCoefficient();
		System.out.println(obj.findCoefficientRec(4, 2));
		System.out.println(obj.findCoefficientTabulation(4, 2));
		System.out.println(obj.findCoefficientRec(5, 2));
		System.out.println(obj.findCoefficientTabulation(5, 2));
	}

}
