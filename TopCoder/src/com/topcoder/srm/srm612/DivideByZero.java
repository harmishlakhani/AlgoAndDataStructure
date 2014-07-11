package com.topcoder.srm.srm612;


public class DivideByZero {
	
	public int count(String S) {
		
		int count = 0;
		int length = S.length();
		
		for(int i = 0; i < length - 1; i++) {
			
			if(S.charAt(i) == 'R' && S.charAt(i+1) == 'L') {
				count++;
				i++;
			}
		}
		return count;
	}
				
	public static void main(String[] args) {

		DivideByZero obj = new DivideByZero();
		
		System.out.println(obj.count("L"));
		System.out.println(obj.count("RRR"));
		System.out.println(obj.count("LRLRLR"));
		
		
	}

}

