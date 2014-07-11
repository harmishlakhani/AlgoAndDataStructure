package com.topcoder.srm.srm627;

public class Class500 {

	public char getHappyLetter(String letters) {

		int[] index = new int[26];
		
		for(int i = 0; i < letters.length(); i++)
			index[letters.charAt(i) - 97]++;
		
		int max = Integer.MIN_VALUE, maxI = 97;
		int total = 0;
		
		for(int i = 0; i < 26; i++) {
			if(max < index[i]) {
				max = index[i];
				maxI = i;
			}
			total += index[i];
		}
		
		if(max <= (total - max))
			return '.';
		return (char) (maxI + 97);
	}

	public static void main(String[] args) {

		Class500 obj = new Class500();

		System.out.println(obj.getHappyLetter("aaabc"));
	}

}
