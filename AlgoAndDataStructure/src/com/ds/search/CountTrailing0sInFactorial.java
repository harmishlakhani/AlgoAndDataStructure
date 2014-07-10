package com.ds.search;

public class CountTrailing0sInFactorial {

	public static int count(int number) {
		
		int count = 0;
		
		if(number == 5)
			return 1;
		
		for(int i = 5; number / i >= 1; i = i * 5) {
			count += number / i;
		}
		
		return count;
	}

	public static void main(String[] args) {
		
		System.out.println(count(10));

	}

}
