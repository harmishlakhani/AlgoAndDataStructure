package com.mix;

import java.util.Scanner;

public class RotateMatrix {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int[][] mat = new int[M][N];
		int[][] rotated = new int[N][M];
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				rotated[j][M - 1 - i] = mat[i][j];
			}
		}
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(rotated[i][j] + " ");
			}
			System.out.println();
		}
	}

}
