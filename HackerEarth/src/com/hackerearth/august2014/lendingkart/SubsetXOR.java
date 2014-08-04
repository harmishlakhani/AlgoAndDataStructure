package com.hackerearth.august2014.lendingkart;

import java.util.Scanner;

public class SubsetXOR {

	public int xor(int[] array) {
		
		int n = 0;
		int length = array.length;
		
		int r, num, temp = 0;
	    for (int i = 0; i <= length; i++) {
	        num = 1;
	        r = i + 1;
	        temp = 0;
	        for (int col = 0; col <= i; col++) {
	            if (col > 0) {
	                num = num * (r - col) / col;    
	            }
	            temp += num;
	        }
	    }

	    for(int i = 0; i < length; i++) {
	    	if(temp % 2 != 0)
	    		n ^= array[i];
	    }
		
		return n;
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SubsetXOR obj = new SubsetXOR();

		int T = sc.nextInt();
		
		for(int i = 0; i < T; i++) {
			int size = sc.nextInt();
			int[] array = new int[size];
			for(int j = 0; j < size; j++)
				array[j] = sc.nextInt();
			System.out.println(obj.xor(array));
		}
	}

}
