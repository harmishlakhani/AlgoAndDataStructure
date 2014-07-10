package com.dp;

public class LongestIncreasingSubSequence {

	private int[] table;
	private int[] prev;
	
	public void longIncSubSeq(int[] array) {
		
		int length = array.length;
		table = new int[length];
		prev = new int[length];
		
		for(int i = 0; i < length; i++) {
			table[i] = 1;
			prev[i] = i;
		}
		
		for(int i = 1; i < length; i++) {
			
			for(int j = i - 1; j >= 0; j--) {
				if(array[i] > array[j] && table[i] < table[j] + 1) {
					table[i] = table[j] + 1;
					prev[i] = j;
				}
			}
		}
	}
	
	public void longIncSubSeqPrint(int[] array) {
		int max = table[0];
		int end = 0;
		for(int i = 1; i < table.length; i++) {
			if(max < table[i]) {
				max = table[i];
				end = i;
			}
		}
		
		System.out.println("Length is " + max);
		
		int i = end;
		for(; prev[i] != i; i = prev[i]) {
			System.out.print(array[i] + " ");
		}
		System.out.print(array[i] + " ");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		LongestIncreasingSubSequence obj = new LongestIncreasingSubSequence();
		int[] array = new int[]{ 10, 22, 9, 33, 21, 50, 60, 80 };
		obj.longIncSubSeq(array);
		obj.longIncSubSeqPrint(array);
	}

}
