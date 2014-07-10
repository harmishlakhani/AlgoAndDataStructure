package com.dp;

public class MinCostPath {

	public int minCostRec(int[][] array, int row, int col) {
			
		if(row < 0 || col < 0)
			return Integer.MAX_VALUE;
		
		if(row == 0 && col == 0)
				return array[0][0];
			
		return array[row][col] + Math.min(minCostRec(array, row - 1, col - 1),
				Math.min(minCostRec(array, row - 1, col), minCostRec(array, row, col - 1)));
	}
	
	public void minCostTabulation(int[][] array, int row, int col) {
		
		int[][] dp = new int[row][col];
		dp[0][0] = array[0][0];
		
		for(int i = 1; i < row; i++)
			dp[i][0] = dp[i - 1][0] + array[i][0];
		
		for(int j = 1; j < col; j++)
			dp[0][j] = dp[0][j - 1] + array[0][j];
		
		for(int i = 1; i < row; i++) {
		
			for(int j = 1; j < col; j++) {
				dp[i][j] = array[i][j] + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
			}
		}
		
		System.out.println("Min cost is : " + dp[row - 1][col - 1]);
		System.out.println("Path is as follows");
		System.out.print("(" + (row - 1) + ", " + (col - 1) + ")  <- ");
		for(int i = row - 1, j = col - 1; i > 0 && j > 0; ) {
				
			if(dp[i - 1][j - 1] < dp[i - 1][j]) {
				if(dp[i - 1][j - 1] < dp[i][j - 1]) {
					i--;
					j--;
				} else {
					j--;
				}
				
			} else {
				if(dp[i - 1][j] < dp[i][j - 1]) {
					i--;
				} else {
					j--;
				}
			}
			System.out.print("(" + i + ", " + j + ")  <- ");
		}
		System.out.print("(0, 0)");
		
	}
	
	public static void main(String[] args) {
		
		MinCostPath obj = new MinCostPath();
		
		int[][] matrix = new int[][]{{1, 2, 3},{4, 8, 2},{1, 5, 3}};
		obj.minCostTabulation(matrix, 3, 3);
		System.out.println(obj.minCostRec(matrix, 2, 2));

	}
}
