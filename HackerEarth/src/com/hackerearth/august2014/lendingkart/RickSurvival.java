package com.hackerearth.august2014.lendingkart;

import java.util.Arrays;
import java.util.Scanner;

public class RickSurvival {

	public void survival(int[] array) {
		
		Arrays.sort(array);
		
		int time = 0;
		int count = 0;
		int length = array.length;
		
		for(int i = 0; i < length; i++) {
			if(Math.abs(array[i] - time) == 0) {
				System.out.println("Goodbye Rick");
				System.out.println(count);
				return;
			}
			time++;
			count++;
			if(count % 6 == 0)
				time++;
				
		}
		System.out.println("Rick now go and save Carl and Judas");
	}
	
	public static void main(String args[] ) throws Exception {
	       Scanner sc = new Scanner(System.in);
			//TestClass obj = new TestClass();

			int T = sc.nextInt();
			
			for(int i = 0; i < T; i++) {
				int size = sc.nextInt();
				String input = sc.nextLine();
				String[] numbers = input.split(" ");
				
				int[] array = new int[size];
				for(int j = 0; j < size; j++)
					array[j] = Integer.parseInt(numbers[j]);
				//obj.survival(array);
				Arrays.sort(array);
			
				int time = 0;
				int count = 0;
				int length = array.length;
				boolean flag = true;
				for(int j : array) {
					if(j - time <= 0) {
						System.out.println("Goodbye Rick");
						System.out.println(count);
						flag = false;
						break;
					}
					time++;
					count++;
					if(count % 6 == 0)
						time++;
						
				}
				if(flag)
					System.out.println("Rick now go and save Carl and Judas");
				}
	    }
	}