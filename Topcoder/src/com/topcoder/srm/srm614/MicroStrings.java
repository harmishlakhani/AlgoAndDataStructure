package com.topcoder.srm.srm614;

import java.util.Arrays;

public class MicroStrings {
	
	public String makeMicroString(int A, int D) {
		
		StringBuilder sb = new StringBuilder();
		sb.append(A);
		int temp = 0;
		
		for(int i = 1; ; i++) {
			temp = A - (i * D);
			if(temp < 0)
				break;
			sb.append(temp);
		}
		
		return sb.toString();
	}
				
	public static void main(String[] args) {

		MicroStrings obj = new MicroStrings();
		
		System.out.println(obj.makeMicroString(30,6));
		
		
	}

}

