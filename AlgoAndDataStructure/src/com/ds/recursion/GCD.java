package com.ds.recursion;

class GCD {

	public static int gcd(int a, int b) {
		if(b == 0) return a;
		return gcd(b, a % b);
	}	
	
	public static void main(String[] args) {
	
		int n = GCD.gcd(12, 8);
		System.out.println("GCD is " + n);
	}
}
