package com.careercup.appliedmaths;

public class TrickyArithmetic {

	public int addWithoutPlusOperator(int x, int y) {
		
		if(y == 0) return x;
		
		int sum = x ^ y;
		int carry = x & y;
		carry = carry << 1;
		return addWithoutPlusOperator(sum, carry);
	}
	
	public int minusWithPlusOperator(int x, int y) {
		
		return x + negate(y);
	}
	
	public int mulWithPlusOperator(int x, int y) {
		
		//to make it faster
		if(x < y) 
			return mulWithPlusOperator(y, x);
		
		int total = 0;
		
		for(int i = 0; i < Math.abs(y); i++)
			total += x;
		
		//to negate result if y is negative.
		if(y < 0)
			total = negate(total);
		
		return total;
	}
	
	public int divWithPlusOperator(int x, int y) {
		
		int count = 0, temp = 0;
		boolean flag = (x > 0 && y < 0) || (x < 0 && y > 0) ? true : false;
		
		if(x < 0)
			x = negate(x);
		if(y < 0)
			y = negate(y);
		
		while(temp < x) {
			temp += y;
			if(temp <= x)
				count++;
		}
		
		if(flag) 
			count = negate(count);
		
		return count;
	}
	
	private int negate(int x) {
		
		int sign = x < 0 ? 1 : -1;
		int neg = 0;
		
		while(x != 0) {
			x = x + sign;
			neg = neg + sign;
		}
		
		return neg;
	}
	public static void main(String args[]) {
		
		TrickyArithmetic obj = new TrickyArithmetic();
		//System.out.println(obj.mulWithPlusOperator(2,10));
		//System.out.println(obj.minusWithPlusOperator(-10,9));
		//System.out.println(obj.divWithPlusOperator(2,-20));
		System.out.println(obj.addWithoutPlusOperator(-52,-53));		
		//System.out.println(obj.negate(0));
	}
}
