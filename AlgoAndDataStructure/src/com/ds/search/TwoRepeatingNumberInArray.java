package com.ds.search;

import com.ds.recursion.*;

public class TwoRepeatingNumberInArray {

	//O(n) using addition and multiplication
	public void twoRepeatingNumberUsingMaths(int[] array, int n) {
		
		int S = 0;
		int P = 1;
		int XPlusY = 0;
		int XMulY = 1;
		int XMinusY = 0;
		int X = 0;
		int Y = 0;
		
		for(int i = 0; i < array.length; i++) {
			S = S + array[i];
			P = P * array[i];
		}
		
		int SUM = n * (n + 1) / 2;
		int PRODUCT = Factorial.factorial(n);
		
		XPlusY = S - SUM;
		XMulY = P / PRODUCT;
		
		XMinusY = (int) Math.sqrt(Math.pow(XPlusY, 2) - 4 * XMulY);
		
		X = (XPlusY + XMinusY ) / 2;
		Y = XMulY / X;
		
		System.out.println("X is " + X + " : Y is " + Y);
	}
	
	//O(n) using XOR
	public void twoRepeatingNumberUsingXOR(int[] array, int n) {
		
		int XOR = 0;
		int right_most_bit = 0;
		int X = 0, Y = 0;
		
		for(int i = 0; i < array.length; i++) {
			XOR ^= array[i];
		}
		
		for(int i = 1; i <= n; i++) {
			XOR ^= i;
		}
		
		right_most_bit = XOR & ~(XOR - 1);
		
		for(int i = 0; i < array.length; i++) {
			if((array[i] & right_most_bit) == right_most_bit)
				X ^= array[i];
			else
				Y ^= array[i];
		}
		
		for(int i = 1; i <= n; i++) {
			if((i & right_most_bit) == right_most_bit)
				X ^= i;
			else
				Y ^= i;
		}
		
		System.out.println("X is " + X + " : Y is " + Y);
	}
	
	public static void main(String[] args) {

		TwoRepeatingNumberInArray obj = new TwoRepeatingNumberInArray();
		obj.twoRepeatingNumberUsingMaths(new int[]{1,2,3,4,5,5,6,7,8,9,10,10}, 10);
		obj.twoRepeatingNumberUsingXOR(new int[]{1,1,1,2,2,3,3,4,4,4,5,5,5,6,6,6,7,7,7}, 7);
	}

}
