package com.hackerrank.euler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class NumberToWords1 {

	public static void main(String[] args) throws IOException {

		Map<Long, String> map = new HashMap<Long, String>();
		fillBaseValues(map);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int a = 0; a < t; a++) {
			
			String number = br.readLine();
			long n = Long.parseLong(number);

			if(n <= 20) {
				System.out.println(map.get(n));
			} else if(n <= 99){
				long reminder = n % 10;
				System.out.println(map.get(n - reminder) + " " + map.get(reminder));
			} else {

				StringBuilder sbr = new StringBuilder();
				int count = 0;
				
				while(n > 0) {
					
					long reminder = n % 10;
					n = n / 10;
					
					if(reminder != 0) {
						if(count < 3) {
							sbr.insert(0, map.get(reminder * ((long)Math.pow(10, count))) + " ");	
						} else if(count == 3) {
							sbr.insert(0, map.get(reminder) + " " + map.get((long)Math.pow(10, count)) + " ");
						} else if(count < 6) {
							sbr.insert(0, map.get(reminder * ((long)Math.pow(10, count) / 1000)) + " ");	
						} else if(count == 6) {
							sbr.insert(0, map.get(reminder) + " " + map.get((long)Math.pow(10, count)) + " ");
						} else if(count < 9) {
							sbr.insert(0, map.get(reminder * ((long)Math.pow(10, count) / 1000000)) + " ");	
						} else if(count == 9) {
							sbr.insert(0, map.get(reminder) + " " + map.get((long)Math.pow(10, count)) + " ");
						} else if(count < 12) {
							sbr.insert(0, map.get(reminder * ((long)Math.pow(10, count) / 1000000000)) + " ");	
						}
					}
					count++;
				}
				sbr.deleteCharAt(sbr.length() - 1);
				System.out.println(sbr.toString());
			}
			
		}
	}
	
	public static void fillBaseValues(Map<Long, String> map) {
		
		map.put(1L, "One");
		map.put(2L, "Two");
		map.put(3L, "Three");
		map.put(4L, "Four");
		map.put(5L, "Five");
		map.put(6L, "Six");
		map.put(7L, "Seven");
		map.put(8L, "Eight");
		map.put(9L, "Nine");
		map.put(10L, "Ten");
		map.put(11L, "Eleven");
		map.put(12L, "Twelve");
		map.put(13L, "Thirteen");
		map.put(14L, "Fourteen");
		map.put(15L, "Fifthteen");
		map.put(16L, "Sixteen");
		map.put(17L, "Seventeen");
		map.put(18L, "Eighteen");
		map.put(19L, "Nineteen");
		
		map.put(20L, "Twenty");
		map.put(30L, "Thirty");
		map.put(40L, "Fourty");
		map.put(50L, "Fifty");
		map.put(60L, "Sixty");
		map.put(70L, "Seventy");
		map.put(80L, "Eighty");
		map.put(90L, "Ninety");
		
		map.put(100L, "One Hundred");
		map.put(200L, "Two Hundred");
		map.put(300L, "Three Hundred");
		map.put(400L, "Four Hundred");
		map.put(500L, "Five Hundred");
		map.put(600L, "Six Hundred");
		map.put(700L, "Seven Hundred");
		map.put(800L, "Eight Hundred");
		map.put(900L, "Nine Hundred");
		
		map.put(1000L, "Thousand");
		map.put(1000000L, "Million");
		map.put(1000000000L, "Billion");
		map.put(1000000000000L, "Trillion");
	}
}