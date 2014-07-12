package com.dp;

public class CuttingRoad {

	public int cut(int[] array, int n) {
		
		if(n ==0)
			return 0;
		int max = Integer.MIN_VALUE, value;
		
		for(int i = 0; i < n; i++) {
			value = array[i] + cut(array, n - i - 1);
			if(max < value)
				max = value;
		}
		return max;
	}
	
	public int cutTabulation(int[] array, int n) {
		
		int[] dp = new int[n + 1];
		dp[0] = 0;
		
		for(int i = 1; i <= n; i++) {
			dp[i] = Integer.MIN_VALUE;
			for(int j = 0; j < i; j++) {
				if(dp[i] < array[j] + dp[i - j - 1])
					dp[i] = array[j] + dp[i - j - 1];
			}
		}
		
		return dp[n];
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CuttingRoad obj = new CuttingRoad();
		System.out.println(obj.cut(new int[]{1, 5, 8, 9, 10, 17, 17, 20}, 8));
		System.out.println(obj.cutTabulation(new int[]{1, 5, 8, 9, 10, 17, 17, 20}, 8));
	}

}
