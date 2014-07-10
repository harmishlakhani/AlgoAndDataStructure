package com.topcoder.srm.srm617;

public class SlimeXSlimonadeTycoon {
	
	public int sell(int[] morning, int[] customers, int stale_limit) {
		
		int total = 0;
		int N = morning.length;
		
		for(int i = 0; i < N; i++) {
		
			int temp = 0;
			int j = i - stale_limit + 1 > 0 ? i - stale_limit + 1 : 0;
			
			for( ;j <= i; j++) {
				if(customers[i] > 0) {
					if(customers[i] >=  morning[j]) {
						temp += morning[j];
						customers[i] -= morning[j];
						morning[j] = 0;
					} else {
						temp += customers[i];
						morning[j] -= customers[i]; 
						customers[i] = 0;
					}
				}
			}
			
			total = total + temp;
		}
		
		return total;
	}
				
	
	public static void main(String[] args) {

		SlimeXSlimonadeTycoon obj = new SlimeXSlimonadeTycoon();
		 
		System.out.println(obj.sell(new int[] {10000, 0, 0, 0, 0, 0, 0}, new int[]{1, 2, 4, 8, 16, 32, 64},4));
		
		
	}

}

