package com.hackerrank.booking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class BookingB {

	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<String> list = new ArrayList<String>();
		
		while(true) {
			String a = br.readLine();
			if(a.isEmpty()) {
				break;
			}
			list.add(a);
		}
		
		int N = list.size();
		int[] index = new int[N];
		String[] array = new String[N];
		
		for(int i = 0; i < N; i++) {
			String aaa = list.get(i).replaceAll(" ", "");
			char[] chars = aaa.toCharArray();
	        Arrays.sort(chars);
	        String temp = new String(chars);
	        array[i] = temp;
	        index[i] = i;
		}
		
		for(int i = 0; i < N - 1; i++) {
			int minI = i;
			String min  = array[i];
			for(int j = i + 1; j < N; j++) {
				if(array[j].compareTo(min) < 0) {
					min = array[j];
					minI = j;
				}
			}
			String a = array[i];
			array[i] = array[minI];
			array[minI] = a;
			
			int b = index[i];
			index[i] = index[minI];
			index[minI] = b;
		}
		
		for(int i = 0; i < N - 1; i++) {
			while((i < N - 1) && array[i].equalsIgnoreCase(array[i + 1])) {
				System.out.print(list.get(index[i]) + ",");
				i++;
			}
			System.out.print(list.get(index[i]) + ",");
			System.out.println();
		}
	}
}