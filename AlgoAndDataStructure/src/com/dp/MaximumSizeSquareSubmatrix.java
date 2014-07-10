package com.dp;

public class MaximumSizeSquareSubmatrix {

	public void maxSizeSubMatrix(int[][] array, int row, int col) {
		
		int[][] dp = new int[row][col];
		
		for(int i = 0; i < row; i++) {
			dp[i][0] = array[i][0];
		}
		
		for(int i = 0; i < col; i++) {
			dp[0][i] = array[0][i];
		}
		
		for(int i = 1; i < row; i++) {
			for(int j = 1; j < col; j++) {
				if(array[i][j] == 1) {
					dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
				} 
			}
		}
		
		int max = dp[0][0];
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				System.out.print(dp[i][j] + " ");
				if(max < dp[i][j])
					max = dp[i][j];
			}
			System.out.println();
		}
		
		System.out.println("Max size is : " + max);
	}
	
	public static void main(String[] args) {

		MaximumSizeSquareSubmatrix obj = new MaximumSizeSquareSubmatrix();
		
		int[][] array = new int[][]{
				{0, 1, 1, 0, 1}, 
                {1, 1, 0, 1, 0}, 
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}
		};
        
		obj.maxSizeSubMatrix(array, 6, 5);
    }
}
