package com.hackerrank.euler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargestProductInGrid {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int SIZE = 20;
		int LENGTH = 4;
		int max = Integer.MIN_VALUE;

		int[][] grid = new int[SIZE][SIZE];

		for (int i = 0; i < SIZE; i++) {
			String[] array = br.readLine().split(" ");
			for (int j = 0; j < SIZE; j++) {
				grid[i][j] = Integer.parseInt(array[j]);
			}
		}

		// Horizontal cases
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE - LENGTH  + 1; j++) {
				int prod = 1;
				for(int k = 0; k < LENGTH; k++){
					prod = prod * grid[i][j + k];
				}
				if(prod > max)
					max = prod;
			}
		}
		
		// Vertical cases
		for (int j = 0; j < SIZE; j++) {
			for (int i = 1; i < SIZE - LENGTH + 1; i++) {
				int prod = 1;
				for(int k = 0; k < LENGTH; k++){
					prod = prod * grid[i + k][j];
				}
				if(prod > max)
					max = prod;
			}
		}
		
		// Diag Forwar cases
		for (int i = 0; i < SIZE - LENGTH + 1; i++) {
			for (int j = 0; j < SIZE - LENGTH + 1; j++) {
				
				int prod = 1;
				for(int k = 0; k < LENGTH; k++){
					prod = prod * grid[i + k][j + k];
				}
				
				if(prod > max)
					max = prod;
			}
		}

		// Diag Forwar cases
		for (int i = 0; i < SIZE - LENGTH + 1; i++) {
			for (int j = SIZE - 1; j >= LENGTH - 1; j--) {
				
				int prod = 1;
				for(int k = 0; k < LENGTH; k++){
					prod = prod * grid[i + k][j - k];
				}
				
				if(prod > max)
					max = prod;
			}
		}
		System.out.println(max);

	}

}