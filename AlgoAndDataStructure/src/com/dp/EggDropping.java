package com.dp;

public class EggDropping {

	public int eggDropRec(int n, int k) {
		
		if(k == 0 || k == 1)
			return k;
		
		if(n == 1)
			return k;
		int min = Integer.MAX_VALUE, res;
		for(int i = 1; i <= k; i++) {
			res = Math.max(eggDropRec(n - 1, i - 1), eggDropRec(n, k - i));
			if(min > res)
				min = res;
		}
		
		return min + 1;
	}
	
	public int eggDropTabulation(int n, int k) {
		
		int[][] dp = new int[n + 1][k + 1];
		int temp;
		for(int i = 0; i <= n; i++) {
			dp[i][0] = 0;
			dp[i][1] = 1;
		}
		
		for(int j = 0; j <= k; j++) {
			dp[1][j] = j;
		}
		
		for(int i = 2; i <= n; i++) {
			for(int j = 2; j <= k; j++) { 
				
				dp[i][j] = Integer.MAX_VALUE;
				for(int x = 1; x <= j; x++) {
					temp = 1 + Math.max(dp[i - 1][x - 1], dp[i][j - x]);
					if(temp < dp[i][j])
						dp[i][j] = temp;
				}
			}
		}
		return dp[n][k];
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EggDropping obj = new EggDropping();
		System.out.println(obj.eggDropRec(2, 10));
		System.out.println(obj.eggDropTabulation(2, 10));
	}

}
