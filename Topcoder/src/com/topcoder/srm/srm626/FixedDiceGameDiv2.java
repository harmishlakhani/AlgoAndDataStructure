package com.topcoder.srm.srm626;



public class FixedDiceGameDiv2 {
	
	public double getExpectation(int a, int b) {
		
		double total = 0;
		double count = 0;
		//int min = Math.min(a, b);
		//int max = Math.max(a, b);
		
		for(int j = 1; j <= a; j++) {
			
			for(int i = 1; i <= b; i++) {
				if(j > i) {
					total += j;
					count++;
				}
				
			}
		}
		return total / count;
	}
				
	public static void main(String[] args) {

		FixedDiceGameDiv2 obj = new FixedDiceGameDiv2();
		System.out.println(obj.getExpectation(11,13));
	}

}
