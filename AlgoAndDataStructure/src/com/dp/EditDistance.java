package com.dp;

public class EditDistance {

	//recursive
	public int editDistanceRec(char[] a, char[] b, int la, int lb) {
		
		if(la == 0 && lb == 0)
			return 0;
		if(la == 0)
			return lb;
		if(lb == 0)
			return la;
		
		if(a[la - 1] == b[lb - 1])
			return editDistanceRec(a, b, la - 1, lb - 1);
		
		int x = editDistanceRec(a, b, la - 1, lb) + 1;
		int y = editDistanceRec(a, b, la, lb - 1) + 1;
		int z = editDistanceRec(a, b, la - 1, lb - 1) + 1;
		
		return Math.min(x, Math.min(y, z));
	}
	
	public int editDistanceTabulation(char[] a, char[] b, int la, int lb) {
		
		int[][] dp = new int[la + 1][lb + 1];
		
		for(int i = 0; i < la + 1; i++)
			dp[i][0] = i;
		
		for(int j = 0; j < lb + 1; j++)
			dp[0][j] = j;
		
		for(int i = 1; i < la + 1; i++) {
			for(int j = 1; j < lb + 1; j++) {
				if(a[i - 1] == b[j - 1])
					dp[i][j] = dp[i - 1][j - 1];
				else
					dp[i][j] = Math.min(dp[i][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i - 1][j - 1] + 1));
			}
		}
		
		return dp[la][lb];
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EditDistance obj = new EditDistance();
		String a = "harmish";//"AGGTAB";
		String b = "abr123";//"GXTXAYB";
		System.out.println(obj.editDistanceRec(a.toCharArray(), b.toCharArray(), a.length(), b.length()));
		System.out.println(obj.editDistanceTabulation(a.toCharArray(), b.toCharArray(), a.length(), b.length()));

	}

}
