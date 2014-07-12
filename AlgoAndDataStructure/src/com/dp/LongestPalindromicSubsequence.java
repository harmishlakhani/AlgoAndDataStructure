package com.dp;

public class LongestPalindromicSubsequence {

	//This is recursive solution
	public int lpsRec(char[] a, int start, int end) {
		
		if(start == end)
			return 1;

		if(a[start] == a[end] && start + 1 == end)
			return 2;
		
		if(a[start] != a[end])
			return Math.max(lpsRec(a, start + 1, end), lpsRec(a, start, end - 1));
		
		return 2 + lpsRec(a, start + 1, end - 1);
	}
	
	//This is DP-tabulation solution
	public int lpsTablulation(char[] a, int length) {
		
		int[][] dp = new int[length][length];
		
		for(int i = 0; i < length; i++)
			dp[i][i] = 1;
		
		for(int len = 2; len <= length; len++) {
			
			for(int i = 0; i < length - len + 1; i++) {
				int j = i + len - 1;
				if(a[i] == a[j])
					dp[i][j] = 2 + dp[i + 1][j - 1];
				else if(a[i] == a[j] && i + 1 == j)
					dp[i][j] = 2;
				else
					dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
			}
		}
		return dp[0][length - 1];
	}
	
	public static void main(String[] args) {
		
		LongestPalindromicSubsequence obj = new LongestPalindromicSubsequence();
		String a = "BBABCBCAB";
		System.out.println(obj.lpsRec(a.toCharArray(), 0, a.length() - 1));
		System.out.println(obj.lpsTablulation(a.toCharArray(), a.length()));

	}

}
