package com.topcoder.srm.srm609;


public class MagicalStringDiv2 {
	
	public int minimalMoves(String S) {
		
		int k = 0;
		int lenght = S.length();
		
		for(int i = lenght / 2, j = lenght / 2 - 1; j >= 0 && i <= lenght - 1 ; j--, i++) {
			if(S.charAt(i) == '>' ) {
				k++;
			}
			if(S.charAt(j) == '<' ) {
				k++;
			}
				
		}
			
		return k;
	}
				
	public static void main(String[] args) {

		MagicalStringDiv2 obj = new MagicalStringDiv2();
		
		System.out.println(obj.minimalMoves("<<>>"));
		
		
	}

}

