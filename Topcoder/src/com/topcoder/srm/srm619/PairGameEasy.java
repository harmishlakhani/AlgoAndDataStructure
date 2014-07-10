package com.topcoder.srm.srm619;

public class PairGameEasy {
	
	public String able(int a, int b, int c, int d) {
		
		if(isAble(a, b, c, d))
			return "Able to generate";
		else
			return "Not able to generate";
	}
	
	private boolean isAble(int a, int b, int c, int d) {
		
		if(a == c && b == d)
			return true;
		
		if(a > c || b > d)
			return false;
		
		return isAble(a, a + b, c, d) || isAble(a + b, b, c, d);
	}
	
	/*public String able(int a, int b, int c, int d) {
		
		if(c < a || d < b)
			return "Not able to generate";
		
		boolean flag1 = false;
		boolean flag2 = false;
		
		for(int i = 0; ;i++) {
			int temp = a * i;
			if((c - temp) % b == 0) {
				flag1 = true;
				break;
			}
			if(temp > c)
				break;
		}
		
		for(int i = 0; ;i++) {
			int temp = a * i;
			if((d - temp) % b == 0) {
				flag2 = true;
				break;
			}
			if(temp > d)
				break;
		}
		
		
		return flag1 && flag2 ? "Able to generate" : "Not able to generate";
	}*/
				
	public static void main(String[] args) {

		PairGameEasy obj = new PairGameEasy();
		System.out.println(obj.able(7, 1, 489, 948));
	}

}