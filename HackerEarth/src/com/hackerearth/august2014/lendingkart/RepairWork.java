package com.hackerearth.august2014.lendingkart;

import java.util.Scanner;

public class RepairWork {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String input = sc.next();
		double op = 0;
		
		int index = -1;
		while(input.charAt(++index) != '0');

		for(int i = index; i < N; i++) {
			
			int start = i + 1;
			int count = 0;
			boolean flag = false;
			while(i < N && input.charAt(i) == '0') {
				/*if(input.charAt(i) == '1') {
					count++;
				}*/
				flag = true;
				i++;
			}
			
			int end = i;
			if(flag)
				op += Math.sqrt(end - start + 1);
		}
		
		System.out.println(op);
	}

}
