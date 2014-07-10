package com.ds.recursion;

class Fibonacci {

	public static int fibonacci(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		return fibonacci(n-1) + fibonacci(n-2);
	}	
	
	public static void main(String[] args) {
	
		int n = Fibonacci.fibonacci(5);
		System.out.println("Fibonacci is " + n);
	}
}
