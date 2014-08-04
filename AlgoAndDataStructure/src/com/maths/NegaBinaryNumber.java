package com.maths;

public class NegaBinaryNumber {

	public String negaBinary(int number) {
		
		StringBuilder str = new StringBuilder();
		int reminder;
		
		while(number != 0) {
			reminder = number % -2;
			number = number / -2;
			
			if(reminder < 0) {
				reminder += 2;
				number += 1;
			}
			str.append(reminder); 
		}
		return str.toString();
	}
	
	public static void main(String[] args) {

		NegaBinaryNumber obj = new NegaBinaryNumber();
		System.out.println(obj.negaBinary(23));

	}

}
