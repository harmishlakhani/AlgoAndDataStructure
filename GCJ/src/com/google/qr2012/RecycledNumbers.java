package com.google.qr2012;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class RecycledNumbers {

	public RecycledNumbers() {

	}
	
	public String execute(Scanner sc, int testCases) {
		
		String op = "Case #" + testCases + ": " ;
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int count = 0;
		
		if(B <= 9)
			return op + count;
		
		for(int i = A; i <= B; i++) {
			String sb = String.valueOf(i);
			for(int j = 1; j < sb.length(); j++) {
				int temp = Integer.parseInt(sb.substring(j) + sb.substring(0, j));
				if(i == temp)
					break;
				else if(i < temp && temp <= B)
					count++;
			}
		}

		return op + count;
	}
	
	public static void main(String[] args) {
		
		RecycledNumbers recycledNumbers = new RecycledNumbers();
		
		String input = "G:\\video_tutorial\\Algorithm\\workspace\\GCJ\\src\\com\\google\\qr2012\\input";
		String output = "G:\\video_tutorial\\Algorithm\\workspace\\GCJ\\src\\com\\google\\qr2012\\output";
		
		try {
			
			Scanner sc = new Scanner(new FileReader(input));
			PrintWriter pw = new PrintWriter(output);
			
			int testCases = sc.nextInt();
			sc.nextLine();
			int i = 1;
			while(i <= testCases) {
				String op = recycledNumbers.execute(sc,i);
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
