package com.topcoder.srm.srm615;

public class LongLongTripDiv2 {
	
	public String isAble(long D, int T, int B) {
		
		if(D < T)
			return "Impossible";
		else if(D == T)
			return "Possible";
		else if(D > T) {
			
			for(int i = 1; i <= T; i++) {
				//long a = i + (long)((T - i) * B);
				if(i + ((long)(T - i) * B) == D)
					return "Possible";
			}
		}
		
		return"Impossible";
	}
				
	
	public static void main(String[] args) {

		LongLongTripDiv2 obj = new LongLongTripDiv2();
		 
		System.out.println(obj.isAble(1000010000100001L,1100011,1000000000));
		
		
	}

}

