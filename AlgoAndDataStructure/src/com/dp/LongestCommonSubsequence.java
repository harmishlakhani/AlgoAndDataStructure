package com.dp;

public class LongestCommonSubsequence {

	//This is recursive solution
	public int lcsRec(char[] a, char[] b, int la, int lb) {
		
		if(la == 0 || lb == 0)
			return 0;
		
		if(a[la - 1] == b[lb - 1]) {
			return 1 + lcsRec(a, b, la - 1, lb - 1);
		} else
			return Math.max(lcsRec(a, b, la - 1, lb), lcsRec(a, b, la, lb - 1));
	}
	
	//This is DP-tabulation solution
	public void lcsTablulation(char[] a, char[] b, int la, int lb) {
		
		int[][] dp = new int[la + 1][lb + 1];
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= la; i++) {
			for(int j = 1; j <= lb; j++) {
		
				if(a[i - 1] == b[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
				else 
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}

		int i = la, j = lb;
		while(i != 0 && j != 0) {
			if(a[i - 1] == b[j - 1]) {
				sb.append(a[i - 1]);
				i--;
				j--;
			} else {
				if(dp[i - 1][j] > dp[i][j - 1]) {
					i--;
				}
				else 
					j--;
			}
				
		}
		
		System.out.println("Length is : " + dp[la][lb]);
		System.out.println("String is " + sb.reverse());
	}
	
	public static void main(String[] args) {
		
		LongestCommonSubsequence obj = new LongestCommonSubsequence();
		String a = "ABCDGH";//"AGGTAB";
		String b = "AEDFHR";//"GXTXAYB";
		//System.out.println(obj.lcsRec(a.toCharArray(), b.toCharArray(), a.length(), b.length()));
		obj.lcsTablulation(a.toCharArray(), b.toCharArray(), a.length(), b.length());

	}

}
