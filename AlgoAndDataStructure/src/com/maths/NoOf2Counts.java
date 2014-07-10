package com.maths;

public class NoOf2Counts {

	public int count(int x) {
		
		int[] array = new int[10];
		int lenght = 0;
		int total = 0;
		
		for(int i = 0; x != 0; i++) {
			array[i] = x % 10;
			x = x / 10;
			lenght = i;
		}
		
		for(int i = lenght; i > 0; i--) {
			
			total += count2InBase10(i) * array[i];
			
			if(array[i] > 2) {
				total += (int) Math.pow(10, i);
			}
			else if(array[i] == 2) {
				int j = i - 1;
				total++;
				while(j >= 0) {
					total += array[j] * (int) Math.pow(10, j);	
					j--;
				}
			}
		}
		
		if(array[0] >= 2)
			total++;
		
		return total;
	}
	
	private int count2InBase10(int index) {
		return index * (int) Math.pow(10, index - 1);
	}
	
	public static void main(String args[]) {
		
		NoOf2Counts obj = new NoOf2Counts();
		//System.out.println(obj.count2InBase10(0));
		System.out.println(obj.count(230));
	}
}