package com.hackerearth.august2014.easychallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Criminals {

	public int number(int[] array) {
		
		int n = 1;
		Arrays.sort(array);
		int length = array.length;
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i < length - 1; i++) {
			if(array[i] >= array[i + 1])
				list.add(array[i]);
		}
		
		while(!list.isEmpty()) {
			List<Integer> temp = new ArrayList<Integer>();
			for(int i = 0; i < list.size() - 1; i++) {
				if(list.get(i) >= list.get(i + 1))
					temp.add(list.get(i));
			}
			
			list = temp;
			n++;
		}
		
		return n;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Criminals obj = new Criminals();

		int T = sc.nextInt();
		
		for(int i = 0; i < T; i++) {
			int size = sc.nextInt();
			int[] array = new int[size];
			for(int j = 0; j < size; j++)
				array[j] = sc.nextInt();
			System.out.println(obj.number(array));
		}
	}

}
