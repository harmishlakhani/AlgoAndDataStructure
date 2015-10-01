package com.hackerrank.euler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class NumberToWords {

	public static void main(String[] args) throws IOException {

		Map<Long, String> map = new HashMap<Long, String>();
		fillBaseValues(map);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int a = 0; a < t; a++) {
			
			String number = br.readLine();
			long n = Long.parseLong(number);

			if(n == 0) {
				System.out.println(map.get(0L));
				continue;
			}
			StringBuilder sbr = new StringBuilder();
			int count = 0;
			
			while(n > 0) {
				
				long temp = n % 1000;
				
				if(temp == 0) {
					n = n / 1000;
					count = count + 3;
					continue;
				}
				StringBuilder chunk = new StringBuilder();
				
				while(temp > 0) {
					if(temp <= 20) {
						chunk.append(map.get(temp));
						temp = 0;
					} else if(temp <= 99){
						long reminder = temp % 10;
						chunk.append(map.get(temp - reminder) + " ");
						if(reminder != 0)
							 chunk.append(map.get(reminder));
						temp = 0;
					} else {
						long first = temp / 100;
						temp = temp % 100;
						chunk.append(map.get(first * 100L) + " ");
					}
				}
				
				if(count < 3) {
					sbr.insert(0, chunk.toString());
				} else if(count == 3) {
					sbr.insert(0, chunk.toString() + " " + map.get(1000L) + " ");
				} else if(count == 6) {
					sbr.insert(0, chunk.toString() + " " + map.get(1000000L) + " ");
				} else if(count == 9) {
					sbr.insert(0, chunk.toString() + " " + map.get(1000000000L) + " ");
				} else if(count == 12) {
					sbr.insert(0, chunk.toString() + " " + map.get(1000000000000L) + " ");
				}
				
				n = n / 1000;
				count = count + 3;
			}
			System.out.println(sbr.toString().trim().replaceAll(" +", " "));
		}
			
	}
	
	public static void fillBaseValues(Map<Long, String> map) {
		
		map.put(0L, "Zero");
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
		map.put(15L, "Fifteen");
		map.put(16L, "Sixteen");
		map.put(17L, "Seventeen");
		map.put(18L, "Eighteen");
		map.put(19L, "Nineteen");
		
		map.put(20L, "Twenty");
		map.put(30L, "Thirty");
		map.put(40L, "Forty");
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