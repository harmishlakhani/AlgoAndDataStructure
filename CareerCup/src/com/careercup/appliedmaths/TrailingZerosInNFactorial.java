package com.careercup.appliedmaths;

public class TrailingZerosInNFactorial {

	public int count(int x) {
		
		int count2 = 0;
		int count5 = 0;
		
		for(int i = 2; i <= x; i = i + 2) {
			int temp = i;
			while(temp % 2 == 0) {
				temp /= 2;
				count2++;
			}
		}
		
		for(int i = 5; i <= x; i = i + 5) {
			int temp = i;
			while(temp % 5 == 0) {
				temp /= 5;
				count5++;
			}
		}
		
		//System.out.println(count2 + "---" + count5);
		return Math.min(count2, count5);
	}
	
	public static void main(String args[]) {
		
		TrailingZerosInNFactorial obj = new TrailingZerosInNFactorial();
		System.out.println(obj.count(20));
	}
}
