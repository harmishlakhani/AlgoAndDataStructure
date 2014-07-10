package com.ds.recursion;

class Combinations {

	public static void combinations(String prefix, String s) {
		System.out.println(prefix);
		for(int i = 0; i < s.length(); i++)
			combinations(prefix + s.charAt(i), s.substring(i+1));
	}	
	
	public static void main(String[] args) {	
		//StringBuilder binary = new StringBuilder();
		Combinations.combinations("", "abc");
		//System.out.println(binary);
	}
}