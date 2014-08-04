package com.hackerearth.august2014.lendingkart;

import java.util.Scanner;

public class BigPAndParty {

	public void luckiness(int A, int[][] array) {
		
		int B = array.length;
		int[] output = new int[A];
		
		for(int i = 1; i < A; i++)
			output[i] = -1;

		for(int i = 0; i < A; i++) {
			for(int j = 0; j < B; j++) {
				if(array[j][2] == 0 && array[j][0] == i) {
					output[array[j][1]] = output[array[j][1]] <= 0 ? output[i] + 1 : Math.min(output[i] + 1, output[array[j][1]]);
				}
			}
			
			for(int j = 0; j < B; j++) {
				if(array[j][2] == 0 && array[j][0] == i) {
					array[j][2] =  1;
				}
			}
		}
		
		for(int i = 1; i < A; i++)
			System.out.println(output[i]);
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		BigPAndParty obj = new BigPAndParty();

		int A = sc.nextInt();
		int B = sc.nextInt();
		int[][] array = new int[B][3];
		
		for(int i = 0; i < B; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			array[i][0] = a > b ? b : a;
			array[i][1] = a > b ? a : b;
			array[i][2] = 0;
		}
		obj.luckiness(A, array);
	}

}
