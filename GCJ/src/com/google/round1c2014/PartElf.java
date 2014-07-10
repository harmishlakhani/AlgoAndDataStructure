package com.google.round1c2014;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class PartElf {
	
	public String execute(Scanner scanner) {
		
		int op = 0;
		
		String[] input = scanner.next().split("/");
		long P = Long.parseLong(input[0]);
		long Q = Long.parseLong(input[1]);

		if(P % 2 == 0 || Q % 2 == 1) 
			return "impossible";
		
		while(P < Q) {
			P = P * 2;
			op++;
		}
		
		return String.valueOf(op);
	}
	
	public static void main(String[] args) {
		
		PartElf partElf = new PartElf();
		
		String input = "G:\\video_tutorial\\Algorithm\\workspace\\GCJ\\src\\com\\google\\round1c2014\\input";
		String output = "G:\\video_tutorial\\Algorithm\\workspace\\GCJ\\src\\com\\google\\round1c2014\\output";
		
		try {
			
			Scanner sc = new Scanner(new FileReader(input));
			PrintWriter pw = new PrintWriter(output);
			
			int testCases = sc.nextInt();
			System.out.println(sc.nextLine());
			int i = 1;
			while(i <= testCases) {
				String op = partElf.execute(sc);
				pw.print("Case #" + i + ": " + op);
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
