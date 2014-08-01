package com.hackerearth.august2014.easychallenge;

import java.util.Scanner;

public class Supertables {

	public int number(int A, int B, int N) {
		
		int n = 0;
		
		for(int i = 1, j = 1; N > 0;) {
		
			while (N > 0 && A * i < B * j) {
				n = A * i;
				i++;
				N--;
			}
			
			while(N > 0 && A * i > B * j) {
				n = B * j;
				j++;
				N--;
			}
			
			while(N > 0 && A * i == B * j) {
				n = A * i;
				i++;
				j++;
				N--;
			}
		}
		
		return n;
	}
	
	public long numberOpt(int A, int B, int N) {
		
		int lcm = 1;
		long n = 0;
		
		int max = A > B ? A : B;
		int min = A > B ? B : A;
				
		for(int i = 1; i <= min; i++) {
			lcm = max * i;
			if(lcm % min == 0)
				break;
		}
		
		int tempN = 0, count = 0;
		while(tempN <= N) {
			tempN += (lcm / A) + (lcm / B) - 1;
			count++;
		}
		
		tempN = (count - 1) * ((lcm / A) + (lcm / B) - 1);
		n = (long)lcm * (count - 1);
		
		for(long i = (n / A) + 1, j = (n / B) + 1 ; tempN < N;) {
		
			while (tempN < N && A * i < B * j) {
				n = A * i;
				i++;
				tempN++;
			}
			
			while(tempN < N && A * i > B * j) {
				n = B * j;
				j++;
				tempN++;
			}
			
			while(tempN < N && A * i == B * j) {
				n = A * i;
				i++;
				j++;
				tempN++;
			}
		}
		
		return n;
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Supertables obj = new Supertables();

		int T = sc.nextInt();
		
		for(int i = 0; i < T; i++) {
			System.out.println(obj.numberOpt(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
	}

}
