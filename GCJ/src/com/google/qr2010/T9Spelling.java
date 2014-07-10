package com.google.qr2010;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class T9Spelling {

	HashMap<Character, String> repo = new HashMap<Character, String>();
	HashMap<Character, Integer> group = new HashMap<Character, Integer>();

	public T9Spelling() {
		populateRepo();
		populateRepoGroup();
	}

	private void populateRepoGroup() {
		
		group.put(' ', 0);
		group.put('a', 2);
		group.put('b', 2);
		group.put('c', 2);
		group.put('d', 3);
		group.put('e', 3);
		group.put('f', 3);
		group.put('g', 4);
		group.put('h', 4);
		group.put('i', 4);
		group.put('j', 5);
		group.put('k', 5);
		group.put('l', 5);
		group.put('m', 6);
		group.put('n', 6);
		group.put('o', 6);
		group.put('p', 7);
		group.put('q', 7);
		group.put('r', 7);
		group.put('s', 7);
		group.put('t', 8);
		group.put('u', 8);
		group.put('v', 8);
		group.put('w', 9);
		group.put('x', 9);
		group.put('y', 9);
		group.put('z', 9);
		
	}

	private void populateRepo() {
		
		repo.put(' ', "0");
		repo.put('a', "2");
		repo.put('b', "22");
		repo.put('c', "222");
		repo.put('d', "3");
		repo.put('e', "33");
		repo.put('f', "333");
		repo.put('g', "4");
		repo.put('h', "44");
		repo.put('i', "444");
		repo.put('j', "5");
		repo.put('k', "55");
		repo.put('l', "555");
		repo.put('m', "6");
		repo.put('n', "66");
		repo.put('o', "666");
		repo.put('p', "7");
		repo.put('q', "77");
		repo.put('r', "777");
		repo.put('s', "7777");
		repo.put('t', "8");
		repo.put('u', "88");
		repo.put('v', "888");
		repo.put('w', "9");
		repo.put('x', "99");
		repo.put('y', "999");
		repo.put('z', "9999");
		
	}

	public String execute(String input, int testCase) {
		
		int length = input.length();
		StringBuilder sb = new StringBuilder("Case #" + testCase + ": ");
		char prev = ' ';
		for(int i = 0; i < length; i++) {
			if(group.get(prev) == group.get(input.charAt(i)))
				sb.append(" ");
			sb.append(repo.get(input.charAt(i)));
			prev = input.charAt(i);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		T9Spelling spelling = new T9Spelling();
		
		String input = "C:\\PIA\\workspace_GCJ\\GCJ\\src\\com\\google\\qr2010\\input";
		String output = "C:\\PIA\\workspace_GCJ\\GCJ\\src\\com\\google\\qr2010\\output";
		
		try {
			
			Scanner sc = new Scanner(new FileReader(input));
			PrintWriter pw = new PrintWriter(output);
			
			int testCases = sc.nextInt();
			sc.nextLine();
			int i = 1;
			while(i <= testCases) {
				String op = spelling.execute(sc.nextLine(), i);
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
