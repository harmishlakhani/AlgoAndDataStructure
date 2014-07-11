package com.mix;

import java.util.Scanner;

public class RepeatChars {

	public static void main(String[] args) {
		
		int[] hashTable = new int[123];
		
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		if(input.equals("")) {
			System.out.println("NA");
			return;
		}
		
		char inputArray[] = input.toCharArray();
		
		for(int i = 0; i < inputArray.length; i++) {
			hashTable[inputArray[i]]++;
		}
		
		char temp = 0;
		boolean flag = false;
		
		for(int i = 0; i < 26; i++) {
			if(hashTable[i + 65] + hashTable[i + 97] >= 2) {
				if(hashTable[i + 65] >= 1) {
					temp = (char) (i + 65);
					System.out.println(temp);
				} else {
					temp = (char) (i + 97);
					System.out.println(temp);
				}
				flag = true;	
			}
		}
		if(!flag)
			System.out.println("NA");
	}

}
