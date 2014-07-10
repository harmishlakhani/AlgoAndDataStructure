package com.topcoder.srm.srm614;

public class MinimumSquareEasy {
	
	public long minArea(int[] x, int[] y) {
		
		int length = x.length;
		
		int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
		int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
		
		for(int i = 0; i < length; i++) {
			
			if(x[i] > maxX)
				maxX = x[i];
			
			if(y[i] > maxY)
				maxY = y[i];
			
			if(x[i] < minX)
				minX = x[i];
			
			if(y[i] < minY)
				minY = y[i];
		}
		
		int lengthX = (int) Math.abs(maxX - minX);
		int heightY = (int) Math.abs(maxY - minY);
		
		
		if(lengthX == heightY && isN2InSquare(x, y, minX, minY, maxX, maxY))
			return lengthX * heightY;
		else {
			int diff = Math.abs(lengthX - heightY);
			
			if(lengthX > heightY) {
				lengthX -= diff;
				maxX -= diff;
			} else {
				heightY -= diff;
				maxY -= diff;
			}
			
		}
		
		//System.out.println("Max X " + maxX);
		//System.out.println("Max Y " + maxY);
		//System.out.println("Min X " + minX);
		//System.out.println("Min Y " + minY);
		
		return 0;
	}
				
	private boolean isN2InSquare(int[] x, int[] y, int minX, int minY, int maxX, int maxY) {
	
		int length = x.length;
		int count = 0;
		
		for(int i = 0; i < length; i++) {
			if((minX < x[i] && x[i] < maxX) && (minY < y[i] && y[i] < maxY))
				count++;
		}
		
		return (count >= length - 2) ? true : false;
	}
	
	public static void main(String[] args) {

		MinimumSquareEasy obj = new MinimumSquareEasy();
		 
		System.out.println(obj.minArea(new int[] {0, 1, 2}, new int[] {0, 1, 5}));
		
		
	}

}

