package com.thoughtworks;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class RomanCalculation {

	//For storing Symbol Value
	private HashMap<String, Integer> map;
	
	//for validating
	private HashMap<String, String> mapSub;
	
	//for roman to integer conversion
	private TreeMap<Integer, String> revMap;
	
	/**
	 * 
	 */
	RomanCalculation() {
		
		map = new HashMap<String, Integer>();
		
		map.put("I", 1);
		map.put("V", 5);
		map.put("X", 10);
		map.put("L", 50);
		map.put("C", 100);
		map.put("D", 500);
		map.put("M", 1000);
		
		map.put("P", 4);
		map.put("Q", 9);
		map.put("R", 40);
		map.put("S", 90);
		map.put("T", 400);
		map.put("U", 900);
		
		mapSub = new HashMap<String, String>();
		
		mapSub.put("IV", "P");
		mapSub.put("IX", "Q");
		mapSub.put("XL", "R");
		mapSub.put("XC", "S");
		mapSub.put("CD", "T");
		mapSub.put("CM", "U");
		
		revMap = new TreeMap<Integer, String>();
		
		revMap.put(1, "I");
		revMap.put(5, "V");
		revMap.put(10, "X");
		revMap.put(50, "L");
		revMap.put(100, "C");
		revMap.put(500, "D");
		revMap.put(1000, "M");
		revMap.put(4, "IV");
		revMap.put(9, "IX");
		revMap.put(40, "XL");
		revMap.put(90, "XC");
		revMap.put(400, "CD");
		revMap.put(900, "CM");
	}
	
	private boolean isValidRoman(String roman) {
		
		boolean flag = true;
		int lenght = roman.length();
		int countD = 0, countV = 0, countL = 0;
		char currentSymbol = ' ';
		
		
		//start for repetition of D, L and V
		for(int i = 0; i < lenght; i++) {
			
			if(roman.charAt(i) == 'D') {
				countD++;
			} else if(roman.charAt(i) == 'L') {
				countL++;
			} else if(roman.charAt(i) == 'V') {
				countV++;
			}
		}
		
		if(countD > 1 || countL > 1 || countV > 1) {
			flag = false;
			return flag;
		}
		//end for repetition of D, L and V
		
		//start for The symbols "I", "X", "C", and "M" can be repeated three times in succession, but no more.
		for(int i = 0; i < lenght; i++) {
			
			int count = 1;
			currentSymbol = roman.charAt(i);
			
			while(i + 1 < lenght && roman.charAt(i + 1) == currentSymbol) {
				count++;
				i++;
			}
			
			if(count > 3) {
				flag = false;
				return flag;
			}
		}
		//end for The symbols "I", "X", "C", and "M" can be repeated three times in succession, but no more.
		
		//Start
		//"I" can be subtracted from "V" and "X" only. 
		//"X" can be subtracted from "L" and "C" only.
		//"C" can be subtracted from "D" and "M" only. 
		//"V", "L", and "D" can never be subtracted.
		
		Iterator<String> itr = mapSub.keySet().iterator();
		while(itr.hasNext()) {
			String a = itr.next();
			roman = roman.replaceAll(a, mapSub.get(a));
		}
		
		for(int i = 0; i < roman.length() - 1; i++) {
			
			String a = roman.charAt(i) + "";
			String b = roman.charAt(i + 1) + "";
			
			if(map.get(a) < map.get(b)) {
					flag = false;
					return flag;
			}
			
		}
		//End
		
		return flag;
	}
	public int getDecimalFromRoman(String roman) {
		
		int length = roman.length();
		int total = 0;
		int i;
		
		if(!isValidRoman(roman)) {
			System.out.println("Please enter valid roman string");
			return total;
		}
		
		for(i = 0; i < length - 1; i++) {
			
			String a = roman.charAt(i) + "";
			String b = roman.charAt(i + 1) + "";
			
			if(map.get(a) >= map.get(b)) {
				total += map.get(a);
			}
			else {
				total += map.get(b) - map.get(a);
				i++;
			}
		}
		
		if(i == length - 1)
			total += map.get(roman.charAt(i) + "");
		
		return total;
	}
	
	public String getRomanFromDecimal(int decimal) {
		
		StringBuilder roman = new StringBuilder();
		StringBuilder tempRoman = new StringBuilder();
		
		int i = 0, temp = 0;
		
		while(decimal != 0) {
			temp = decimal % 10;
			decimal = decimal / 10;
			
			temp *= Math.pow(10, i);
			tempRoman = new StringBuilder();
			
			while(temp > 0) {
				int a = revMap.floorKey(temp);
				tempRoman.append(revMap.get(a)); 
				temp -= a; 
			}
			roman.insert(0, tempRoman);
			tempRoman = null;
			i++;
		}
		
		return roman.toString();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		RomanCalculation calc = new RomanCalculation();
		System.out.println(calc.getDecimalFromRoman("IXIX"));
		
		System.out.println(calc.getRomanFromDecimal(18));

	}

}
