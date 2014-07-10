package com.ds.recursion;

class MultiplicationAsRecursion {

	public static int multiplication(int a, int b) {
		if(b == 0) return 0;
		if(b % 2 == 0) return multiplication(a+a, b/2);
		return multiplication(a+a, b/2) + a;
	}	
	
	public static void main(String[] args) {
	
		int n = MultiplicationAsRecursion.multiplication(5, 10);
		System.out.println("Mul is " + n);
	}
}
