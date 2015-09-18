package com.hackerrank.euler;
/**
 * Explanation is : http://math.stackexchange.com/questions/9259/find-the-sum-of-all-the-multiples-of-3-or-5-below-1000
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiplesOf3And5 {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int a = 0; a < t; a++) {
			int n = Integer.parseInt(br.readLine());
			long answer = 0;
			
			int x = n / 3;
			if(n % 3 == 0) x--;
			
			int y = n / 5;
			if(n % 5 == 0) y--;
			
			int z = n / 15;
			if(n % 15 == 0) z--;
			
			answer = answer + ((long)3 * x * (x + 1) / 2);
			answer = answer + ((long)5 * y * (y + 1) / 2);
			answer = answer - ((long)15 * z * (z + 1) / 2);
			System.out.println(answer);
		}
		}
}