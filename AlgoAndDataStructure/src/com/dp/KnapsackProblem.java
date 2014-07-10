package com.dp;

public class KnapsackProblem {

	public int knapSackRec(int[] w, int[] v, int W, int n) {
		
		if(W == 0 || n ==0)
			return 0;
		
		else if(w[n - 1] > W)
			return knapSackRec(w, v, W, n - 1);
		
		else 
			return Math.max(knapSackRec(w, v, W, n - 1), v[n - 1] + knapSackRec(w, v, W - w[n - 1], n - 1));
		
	}
	
	public int knapSackTabulation(int[] w, int[] v, int W, int n) {
		
		int[][] dp = new int[n + 1][W + 1];
		
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= W; j++) {
				if(i == 0 || j == 0)
					dp[i][j] = 0;
				else if(w[i - 1] > j)
					dp[i][j] = dp[i - 1][j];
				else
					dp[i][j] = Math.max(dp[i - 1][j], v[i - 1] + dp[i - 1][j - w[i - 1]]);
			}
		}
		
		return dp[n][W];
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		KnapsackProblem obj = new KnapsackProblem();
		System.out.println(obj.knapSackRec(new int[]{10, 20, 30}, new int[] {60, 100, 120}, 50, 3));
		System.out.println(obj.knapSackTabulation(new int[]{10, 20, 30}, new int[] {60, 100, 120}, 50, 3));
	}

}
