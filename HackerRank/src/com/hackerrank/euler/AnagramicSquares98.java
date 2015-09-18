package com.hackerrank.euler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramicSquares98 {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long start = (long) Math.pow(10, n - 1);
		long end = start * 10 - 1;
		
		List<Long> list = new ArrayList<Long>();
		Map<String, ArrayList<Long>> map = new HashMap<String, ArrayList<Long>>();
		
		long number = 1;
		long counter = 1;
		while(number < start) {
			number += 2 * counter + 1;
			counter++;
		}
		
		while(number < end) {
			number += 2 * counter + 1;
			counter++;
			list.add(number);
		}
		
		for(Long a : list) {
			char[] array = a.toString().toCharArray();
			Arrays.sort(array);
			String key = new String(array);
			
			if(map.get(key) != null) {
				map.get(key).add(a);
			} else {
				ArrayList<Long> tempList = new ArrayList<Long>();
				tempList.add(a);
				map.put(key, tempList);
			}
		}
		
		long maxSize = Long.MIN_VALUE;
		String maxKey = "";
		
		for(String key : map.keySet()) {
			int size = map.get(key).size();
			if (size >= maxSize) {
				maxSize = size;
				maxKey = key;
			}
		}
		
		long max = Long.MIN_VALUE;
		List<Long> tempList = map.get(maxKey);
		for(long a : tempList) {
			if (a >= max) {
				max = a;
			}
		}
		System.out.println(max);
	}
}