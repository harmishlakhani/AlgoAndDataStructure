package com.google.round1b2014;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class TheRepeater {
	
	public int execute(Scanner scanner) {
		
		int count = 0;
		int N = scanner.nextInt();
	    String str1 = scanner.next();
	    String str2 = scanner.next();

	    int length1 = str1.length();
	    int length2 = str2.length();
	    
	    for(int i = 0, j = 0;i < length1 && j < length2; i++, j++) {
	    	
	    	int tempI = i;
	    	int tempJ = j;
	    	if(str1.charAt(i) == str2.charAt(j)) {
	    		while(i+1 < length1 && str1.charAt(i) == str1.charAt(i+1))
	    			i++;
	    		while(j+1 < length2 && str2.charAt(j) == str2.charAt(j+1))
	    			j++;
	    		
	    		count += Math.abs((i - tempI) - (j - tempJ));
	    	}
	    	else {
	    		count = -1;
	    		break;
	    	}
	    	
	    }
	    
	    return count;
	}
	
	public static void main(String[] args) {
		
		TheRepeater repeater = new TheRepeater();
		
		String input = "G:\\video_tutorial\\Algorithm\\workspace\\GCJ\\src\\com\\google\\round1c2014\\input";
		String output = "G:\\video_tutorial\\Algorithm\\workspace\\GCJ\\src\\com\\google\\round1c2014\\output";
		
		try {
			
			Scanner sc = new Scanner(new FileReader(input));
			PrintWriter pw = new PrintWriter(output);
			
			int testCases = sc.nextInt();
			System.out.println(sc.nextLine());
			int i = 1;
			while(i <= testCases) {
				int op = repeater.execute(sc);
				if(op != -1)
					pw.print("Case #" + i + ": " + op);
				else
					pw.print("Case #" + i + ": Fegla Won");
				
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
