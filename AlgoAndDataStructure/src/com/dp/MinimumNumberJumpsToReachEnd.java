package com.dp;

public class MinimumNumberJumpsToReachEnd {

	public void minJumps(int[] array) {
		
		int jumps = 0;
		for(int i = array.length - 1; i > 0;) {
			
			int jump = 0;
			for(int j = i - 1; j >= 0; j--) {
				if(i - j <= array[j] && jump < i - j) {
					jump = i - j;
				}
			}
			if(jump == 0) {
				System.out.println("Not possible");
				System.exit(0);
			}
			i = i - jump;
			jumps++;
		}
		System.out.println(jumps);
	}
	
	public static void main(String[] args) {
		MinimumNumberJumpsToReachEnd obj = new MinimumNumberJumpsToReachEnd();
		obj.minJumps(new int[] {0,3,1,1,4});
		obj.minJumps(new int[] {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9});
		obj.minJumps(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
		obj.minJumps(new int[] {4,11,1,1,1,1,1,1,1,1,1,1,1});
	}

}
