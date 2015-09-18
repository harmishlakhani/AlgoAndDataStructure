package com.hackerrank.booking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class EqualLightSabers {

	public int[][] mul(int[][] A, int[][] B) {
		
		int rowsA = A.length;
		int colsA = A[0].length;
		int rowsB = B.length;
		int colsB = B[0].length;
		
		int[][] C = new int[rowsA][colsB];
		
		for(int i = 0; i < rowsA; i++) {
			for(int j = 0; j < colsB; j++) {
				for(int k = 0; k < colsA; k++) {
					C[i][j] += A[i][k] * B[k][j];
				}
			}
			
		}
		
		return C;
	}
	
	public int[][] matpow(int[][] A, int p) {
		
		if(p == 1) {
			return A;
		} else if(p % 2 != 0) {
			return mul(A, matpow(A, p - 1));
		}
		
		int[][] temp = matpow(A, p / 2);
		return mul(temp, temp);
	}
	
	public long fib(int N) {
		
		long value = 0;
		
		int[][] T = new int[][]{{0, 1}, {1, 1}};
		int[] F1 = {1, 1};
		
		if(N == 1)
			return 1;
		
		T = matpow(T, N - 1);
		
		for(int i = 0; i < 2; i++)
			value += (long)T[0][i] * F1[i];
		return value;
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		EqualLightSabers obj = new EqualLightSabers();
		
		int t = Integer.parseInt(br.readLine());
		Map<Integer, Long> map = new HashMap<Integer, Long>();
		
		for(int index = 0; index < t; index++) {
			
			String in[] = br.readLine().split(" ");
			
			int a = Integer.parseInt(in[0]);
			int b = Integer.parseInt(in[1]);
			int count = 0;
			long fibNo = 0;
			for(int i = a; i <= b; i++) {
				
				if(map.containsKey(i + 2)) {
					fibNo = map.get(i + 2);
				} else {
					fibNo = obj.fib(i + 2) - 1;
					map.put(i + 2, fibNo);
				}
				 
				if(fibNo % 2 == 0)
					count++;
			}
			System.out.println(count);
		}
	}
}