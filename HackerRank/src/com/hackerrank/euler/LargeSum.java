package com.hackerrank.euler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargeSum {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int SIZE = 50;
		int N = Integer.parseInt(br.readLine());
		int[][] grid = new int[N + SIZE + 1][SIZE + 10];
		
		for(int a = SIZE; a < N + SIZE; a++) {
			String number = br.readLine();
			
			for(int i = 0; i < SIZE; i++) {
				grid[a][i + 10] = number.charAt(i) - 48;
			}
		}
		
		//for main input (10 to 59 col in grid)
		int sum = 0;
		int row = SIZE - 1;
		for(int col = SIZE + 10 - 1; col >= 10; col--) {
			
			sum = 0;
			for(int i = 0; i < N + SIZE; i++) {
				sum += grid[i][col];
			}

			grid[N + SIZE][col] = sum % 10;
			sum = sum / 10;
			
			int temp = col - 1;
			while (temp > -1 && sum > 0) {
				grid[row][temp] = sum % 10;
				sum /= 10;
				temp--;
			}
			row--;
		}
		
		//for all carries that are out of 1 to 50 ranges (means in 0 to 9 columns of 0 to 59 col grid)
		row = N + SIZE - 1;
		for(int col = 9; col >= 0; col--) {
			
			sum = 0;
			for(int i = 0; i < N + SIZE; i++) {
				sum += grid[i][col];
			}

			grid[N + SIZE][col] = sum % 10;
			sum = sum / 10;
			
			int temp = col - 1;
			while (temp > -1 && sum > 0) {
				grid[row][temp] = sum % 10;
				sum /= 10;
				temp--;
			}
			row--;
		}
		
		int col = 0;
		while(grid[N + SIZE][col] == 0)
			col++;

		for(int i = col; i < col + 10; i++)
			System.out.print(grid[N + SIZE][i]);
	}

}