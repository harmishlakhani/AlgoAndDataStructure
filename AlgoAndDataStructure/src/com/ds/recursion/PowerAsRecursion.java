package com.ds.recursion;

class PowerAsRecursion {

	public static int multiplication(int a, int b) {
		if(b == 0) return 1;
		if(b % 2 == 0) return multiplication(a*a, b/2);
		return multiplication(a*a, b/2) * a;
	}	
	
	public static void main(String[] args) {
	
		int n = PowerAsRecursion.multiplication(5, 3);
		System.out.println("Power is " + n);
	}
}
