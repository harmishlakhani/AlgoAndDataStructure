package com.maths;

public class LCM {

	public int lcm(int A, int B) {
		
		int lcm = 1;

		int max = A > B ? A : B;
		int min = A > B ? B : A;
				
		for(int i = 1; i <= min; i++) {
			lcm = max * i;
			if(lcm % min == 0)
				break;
		}
		
		return lcm;
	}
	
	public static void main(String args[]) {
		
		LCM obj = new LCM();
		System.out.println(obj.lcm(6, 8));
	}
}