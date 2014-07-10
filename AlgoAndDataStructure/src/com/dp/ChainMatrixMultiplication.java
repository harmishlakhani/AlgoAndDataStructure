package com.dp;

public class ChainMatrixMultiplication {

	public int mulRec(int[] p, int i, int j) {
		
		if(i == j)
			return 0;
		
		int min = Integer.MAX_VALUE;
		int count;
		
		for(int k = i; k < j; k++) {
			count = mulRec(p, i, k) + mulRec(p, k + 1, j) + p[i - 1] * p[k] * p[j];
			
			if(min > count)
				min = count;
		}
		
		return min;
	}
	
	public int mulTabulation(int[] p, int n) {	
		
		int[][] dp = new int[n + 1][n + 1];
		int q = Integer.MAX_VALUE;
		
		for(int i = 1; i <= n; i++)
			dp[i][i] = 0;
		
		for(int L = 2; L <= n; L++) {

			for(int i = 1; i <= n - L + 1; i++) {
				
				int j = i + L - 1;
				dp[i][j] = Integer.MAX_VALUE;
				for(int k = i; k < j; k++) {
					q = dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j];
					if(q < dp[i][j])
						dp[i][j] = q;
				}
			}
		}
		
		return dp[1][n];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ChainMatrixMultiplication obj = new ChainMatrixMultiplication();
		System.out.println(obj.mulRec(new int[] {40, 20, 30, 10, 30}, 1, 4));
		System.out.println(obj.mulRec(new int[] {10, 20, 30, 40, 30}, 1, 4));
		System.out.println(obj.mulRec(new int[] {10, 20, 30} , 1, 2));
		
		System.out.println(obj.mulTabulation(new int[] {40, 20, 30, 10, 30}, 4));
		System.out.println(obj.mulTabulation(new int[] {10, 20, 30, 40, 30}, 4));
		System.out.println(obj.mulTabulation(new int[] {10, 20, 30}, 2));
		
	}

}
