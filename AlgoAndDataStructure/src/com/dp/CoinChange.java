package com.dp;

public class CoinChange {

	public int countCoinChangeRec(int[] array, int m, int n) {
		
		if(n == 0)
			return 1;
		
		if(n < 0)
			return 0;
		
		if(n >= 1 && m <= 0)
			return 0;
		
		return countCoinChangeRec(array, m - 1, n) + countCoinChangeRec(array, m, n - array[m - 1]); 
	}
	
	public int countCoinChangeTabulation(int[] array, int m, int n) {
		
		int[][] dp = new int[n+1][m];
		
		for(int i = 0; i < m; i++)
			dp[0][i] = 1;
		
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j < m; j++) {
				int y = i >= array[j] ? dp[i - array[j]][j] : 0;
				int x = j >= 1 ? dp[i][j - 1] : 0;
				dp[i][j] = x + y;
			}
		}
		return dp[n][m-1];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CoinChange obj = new CoinChange();
		System.out.println(obj.countCoinChangeRec(new int[] {1,2,3}, 3, 5));
		System.out.println(obj.countCoinChangeTabulation(new int[] {1,2,3}, 3, 5));
	}

}
