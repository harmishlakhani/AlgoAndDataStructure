package com.ds.recursion;

class PermutationsK {

	public static void permutations(String prefix, String s, int k) {
		int n = s.length();
		
		if(prefix.length() == k) {
			System.out.println(prefix);
			return;
		}
		
		for(int i = 0; i < n; i++)
			permutations(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, n), k);
	}	
	
	public static void permutationsArray(char[] array, int n, int r) {
		
		if(r == 0) {
			
			for(int i = n; i > array.length; i--)
			System.out.print(array[i]);
			
			System.out.println();
			return;
		}
		
		for(int i = 0; i < n; i++) {
			swap(array,i,n-1);
			permutationsArray(array, n-1, r-1);
			swap(array,i,n-1);
		}
	}	
	
	private static void swap(char[] a, int i, int j) {
	   char c;
	   c = a[i]; a[i] = a[j]; a[j] = c;
	}
	
	
	public static void main(String[] args) {	
		//StringBuilder binary = new StringBuilder();
		PermutationsK.permutationsArray(new char[]{'a','b','c','d'}, 4, 2);
		//System.out.println(binary);
	}
}
