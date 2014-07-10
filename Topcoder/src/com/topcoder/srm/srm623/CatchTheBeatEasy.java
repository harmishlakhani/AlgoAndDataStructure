package com.topcoder.srm.srm623;

public class CatchTheBeatEasy {

	public String ableToCatchAll(int[] x, int[] y) {

		int totalDist = 0;
		int tempJ = -1;
		//int totalDist = Math.abs(x[0]);
		
		/*if(totalDist > y[0])
			return "Not able to catch";
		
		for(int i = 1; i < x.length; i++) {
			totalDist += Math.abs(x[i] - x[i - 1]); 
			if(totalDist > y[i])
				return "Not able to catch";
		}*/
		
		for(int i = 0; i <= 1000; i++) {
			
			for(int j = 0; j < x.length; j++) {
				if(i == y[j]) {
					
					if(tempJ != -1)
						totalDist += Math.abs(x[j] - x[tempJ]);
					else
						totalDist += Math.abs(x[j]);
					
					if(totalDist > y[j])
						return "Not able to catch";
					tempJ = j;
					break;
				}
			}
			
		}
		
		return "Able to catch";

	}

	public static void main(String[] args) {

		CatchTheBeatEasy obj = new CatchTheBeatEasy();

		/*System.out.println(obj.ableToCatchAll(new int[] {-1, 1, 0}, new int[] {1, 3, 4}) );
		System.out.println(obj.ableToCatchAll(new int[] {-3}, new int[] {2}) );
		System.out.println(obj.ableToCatchAll(new int[] {-1, 1, 0}, new int[] {1, 2, 4}) );*/
		System.out.println(obj.ableToCatchAll(new int[] {0, -1, 1}, new int[] {9, 1, 3}) );
		
		System.out.println(obj.ableToCatchAll(new int[] {70,-108,52,-70,84,-29,66,-33}, new int[] {141,299,402,280,28,363,427,232}) );
		System.out.println(obj.ableToCatchAll(new int[] {-175,-28,-207,-29,-43,-183,-175,-112,-183,-31,-25,-66,-114,-116,-66}, new int[] {320,107,379,72,126,445,318,255,445,62,52,184,247,245,185}) );
		
		System.out.println(obj.ableToCatchAll(new int[] {0,0,0,0}, new int[] {0,0,0,0}) );

	}

}
