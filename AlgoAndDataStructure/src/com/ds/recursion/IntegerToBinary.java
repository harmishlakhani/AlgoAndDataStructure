package com.ds.recursion;

class IntegerToBinary {

	private static final String ONE = "1";
	private static final String ZERO = "0";
	
	public static void intToBinary(int a, StringBuilder binary) {
		if(a == 1) {
			binary.append(ONE);
			return;
		}
		intToBinary(a/2, binary);
		binary.append(a%2);
	}	
	
	public static void main(String[] args) {	
		StringBuilder binary = new StringBuilder();
		IntegerToBinary.intToBinary(100, binary);
		System.out.println(binary);
	}
}
