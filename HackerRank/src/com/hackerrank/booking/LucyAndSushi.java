package com.hackerrank.booking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class LucyAndSushi {

	public long[][] mul(long[][] A, long[][] B, int Mod) {
		
		int rowsA = A.length;
		int colsA = A[0].length;
		int rowsB = B.length;
		int colsB = B[0].length;
		
		long[][] C = new long[rowsA][colsB];
		
		for(int i = 0; i < rowsA; i++) {
			for(int j = 0; j < colsB; j++) {
				for(int k = 0; k < colsA; k++) {
					C[i][j] += ( A[i][k] * B[k][j] ) % Mod;
				}
			}
			
		}
		
		return C;
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LucyAndSushi obj = new LucyAndSushi();
		
		String[] in = br.readLine().split(" ");
		
		//N L Mod T S A B C
		int N = Integer.parseInt(in[0]);
		int L = Integer.parseInt(in[1]);
		int Mod = Integer.parseInt(in[2]);
		int T = Integer.parseInt(in[3]);
		int S = Integer.parseInt(in[4]);
		int A = Integer.parseInt(in[5]);
		int B = Integer.parseInt(in[6]);
		int C = Integer.parseInt(in[7]);
		
		int[] P = new int[L];
		P[0] = S;
		
		//P[i] = ( ( (A*i^2) + (B*i*P[i-1]) + (C*P[i-1]*P[i-1]) )% Mod ) 
		for(int i = 1; i < L; i++) {
			P[i] = ( ( (A*i*i) + (B*i*P[i-1]) + (C*P[i-1]*P[i-1]) )% Mod );
		}
		
		long[][] matrix = new long[N][N];
		long[][] F = new long[N][N];
		long[][] X = new long[N][N];
		
		matrix[0][0] = T;
		X[0][0] = T;
		for(int i = 1; i < N; i++) {
			matrix[0][i] = (i*matrix[0][i-1] + A) % Mod;
			matrix[i][0] = (i*matrix[i-1][0] + B) % Mod;
			X[0][i] = matrix[0][i];
			X[i][0] = matrix[i][0];
		}
		
		for(int i = 1; i < N; i++) {
			for(int j = 1; j < N; j++) {
				matrix[i][j] =  ( (j*matrix[i][j-1]) + (i*matrix[i-1][j]) + C) % Mod;
				X[i][j] = matrix[i][j];
			}
		}
		
		for(int a = 0; a < N; a++) {
			F[a][a] = P[0] % Mod;
		}
		
		for(int i = 1; i < L; i++) {
			for(int a = 0; a < N; a++) {
				for(int b = 0; b < N; b++) {
					F[a][b] += ((P[i] * X[a][b]) % Mod);
				}
			}
			X = obj.mul(X, matrix, Mod);
		}
		
		int temp1 = 0;
		for(int i = 0, j = 0; i < N && j < N; i++, j++) {
			temp1 += F[i][j] % Mod;
		}
		
		int temp2 = 0;
		for(int i = N - 1, j = 0; i >= 0 && j < N; i--, j++) {
			temp2 += F[i][j] % Mod;
		}
		
		System.out.println((temp1 % Mod) + " " + (temp2 % Mod));
		}
}