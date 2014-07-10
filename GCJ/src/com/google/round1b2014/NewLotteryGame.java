package com.google.round1b2014;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class NewLotteryGame {
	
	public long execute(Scanner scanner) {
		
		long total = 0;
		
		int A = scanner.nextInt();
		int B = scanner.nextInt();
		int K = scanner.nextInt();

		if(K <= A && K <= B) {
		
			total = (long)K * (long)(K + (A - K) + (B - K));
			
			for(int i = K; i < A; i++) {
				for(int j = K; j < B; j++) {
					if((i & j) < K)
						total++;
				}
			}

		} else {
			total = (long)A * B;
		} 
				
		return total;
	}
	
	public static void main(String[] args) {
		
		NewLotteryGame repeater = new NewLotteryGame();
		
		String input = "G:\\video_tutorial\\Algorithm\\workspace\\GCJ\\src\\com\\google\\round1c2014\\input";
		String output = "G:\\video_tutorial\\Algorithm\\workspace\\GCJ\\src\\com\\google\\round1c2014\\output";
		
		try {
			
			Scanner sc = new Scanner(new FileReader(input));
			PrintWriter pw = new PrintWriter(output);
			
			int testCases = sc.nextInt();
			System.out.println(sc.nextLine());
			int i = 1;
			while(i <= testCases) {
				long op = repeater.execute(sc);
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
