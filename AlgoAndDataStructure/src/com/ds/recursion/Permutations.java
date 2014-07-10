package com.ds.recursion;

class Permutations {

	public static void permutations(String prefix, String s) {
		int n = s.length();
		
		if(n == 0) {
			System.out.println(prefix);
			return;
		}
		
		for(int i = 0; i < n; i++)
			permutations(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, n));
	}	
	
	public static void permutationsArray(char[] array, int n) {
		
		if(n == 1) {
			System.out.println(array);
			return;
		}
		
		for(int i = 0; i < n; i++) {
			swap(array,i,n-1);
			permutationsArray(array, n-1);
			swap(array,i,n-1);
		}
	}	
	
	private static void swap(char[] a, int i, int j) {
	   char c;
	   c = a[i]; a[i] = a[j]; a[j] = c;
	}
	
	public static void main(String[] args) {	
		//StringBuilder binary = new StringBuilder();
		//Permutations.permutations("", "12345");
		
		permutationsArray(new char[]{'a','b','c'}, 3);
		//System.out.println(binary);
	}
}
