package com.google.qr2011;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Magicka {

	Map<String, String> combine;
	Map<Character, Character> opps;

	public Magicka() {
	}

	public String execute(Scanner sc, int testCase) {
		
		combine = new HashMap<String, String>();
		opps = new HashMap<Character, Character>();
		StringBuilder sb = new StringBuilder("Case #" + testCase + ": ");
		
		int C = sc.nextInt();
		for(int i = 0; i < C; i++) {
			String temp = sc.next();
			combine.put(temp.charAt(0) + "" + temp.charAt(1), temp.charAt(2) + "");
			combine.put(temp.charAt(1) + "" + temp.charAt(0), temp.charAt(2) + "");
		}
		
		int D = sc.nextInt();
		for(int i = 0; i < D; i++) {
			String temp = sc.next();
			opps.put(temp.charAt(0), temp.charAt(1));
			opps.put(temp.charAt(1), temp.charAt(0));
		}
		
		//System.out.println(combine);
		//System.out.println(opps);
		
		int N = sc.nextInt();
		String input = sc.next();
		StringBuilder op = new StringBuilder();
		
		outerLoop:
		for(int i = 0; i < N; i++) {
			
			char ch1 = input.charAt(i);
			if(op.length() == 0) {
				op.append(input.charAt(i));
				continue outerLoop;
			}
			char ch2 = op.charAt(op.length() - 1);
			
			if(C != 0) {
				String str1 = combine.get(ch1 + "" + ch2);
				String str2 = combine.get(ch2 + "" + ch1);
				
				if(str1 != null || str2 != null) {
					op.deleteCharAt(op.length() - 1);
					op.append(str1);
					continue outerLoop;
				}
			}

			if(D != 0) {
				for(int k = op.length() - 1; k >= 0; k--) {
					if(null != opps.get(ch1) && opps.get(ch1) == op.charAt(k)) {
						op = new StringBuilder();
						continue outerLoop;
					}
				}
			}
			op.append(ch1);
		}
		
		System.out.println(op);
		return sb.append(format(op)).toString();
	}
	
	private StringBuilder format(StringBuilder str) {
		
		StringBuilder op = new StringBuilder("[");
		int N = str.length();
		
		for(int i = 0; i < N; i++) {
			op.append(str.charAt(i) + ", ");
		}
		
		if(N > 0) {
			op.deleteCharAt(op.length() - 1);
			op.deleteCharAt(op.length() - 1);
		}
		
		return op.append("]");
	}
	
	
	public static void main(String[] args) {
		
		Magicka magicka = new Magicka();
		
		String input = "G:\\video_tutorial\\Algorithm\\workspace\\GCJ\\src\\com\\google\\qr2011\\input";
		String output = "G:\\video_tutorial\\Algorithm\\workspace\\GCJ\\src\\com\\google\\qr2011\\output";
		
		try {
			
			Scanner sc = new Scanner(new FileReader(input));
			PrintWriter pw = new PrintWriter(output);
			
			int testCases = sc.nextInt();
			sc.nextLine();
			int i = 1;
			while(i <= testCases) {
				String op = magicka.execute(sc, i);
				pw.print(op);
				pw.println();
				i++;
			}
			
			pw.flush();
            pw.close();
            sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}
