package com.topcoder.srm.srm619;


public class CandidatesSelectionEasy {
	
	public int[] sort(String[] score, int x) {
		
		int length = score.length;
		int[] output = new int[length];
		int index = 0;
		for(int i = 65; i <= 90; i++) {
			for(int j = 0; j < length; j++) {
				if(((int) score[j].charAt(x)) == i) {
					output[index++] = j;
				}
			}
		}
		
		return output;
	}
				
	
	public static void main(String[] args) {

		CandidatesSelectionEasy obj = new CandidatesSelectionEasy();
		 int[] output = obj.sort(new String[] {"X"}, 0);

		 for(int i = 0; i < output.length; i++) {
			 System.out.print(output[i] + " ");
		 }
		
	}

}

