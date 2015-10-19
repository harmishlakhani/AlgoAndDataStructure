package com.hackerrank.euler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NamesScores {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		String[] in = new String[n];
		Map<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < n; i++) {
			in[i] = br.readLine();
		}
		
		Arrays.sort(in);
		BigInteger finalScore = BigInteger.valueOf(0);
		
		for (int i = 0; i < n; i++) {
			String temp = in[i];

			int score = 0;
			for (int j = 0; j < temp.length(); j++) {
				score += (temp.charAt(j) - 64);
			}
			score *= (i + 1);
			map.put(temp, score);
			finalScore = finalScore.add(BigInteger.valueOf(score));
		}

		System.out.println(finalScore);
		/*int q = Integer.parseInt(br.readLine());

		for (int i = 0; i < q; i++) {
			System.out.println(map.get(br.readLine()));
		}*/
	}

}