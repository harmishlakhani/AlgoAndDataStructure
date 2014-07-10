package com.google.qr2013;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class TicTacToe {

	int length = 4;
	char[][] array = new char[4][4];
	HashSet<String> repo = new HashSet<String>();

	public TicTacToe() {
		repo.add("XXXX");
		repo.add("TXXX");
		repo.add("XTXX");
		repo.add("XXTX");
		repo.add("XXXT");
		repo.add("OOOO");
		repo.add("TOOO");
		repo.add("OTOO");
		repo.add("OOTO");
		repo.add("OOOT");
	}
	
	public void getInputFromUser(Scanner a) {
		
		String temp = "";
		for(int i = 0; i < length; i++) {
			temp = a.nextLine();
			for(int j = 0; j < length; j++) {
				array[i][j] = temp.charAt(j);
			}
		}
		
		if(a.hasNextLine()) 
			temp = a.nextLine();
	}

	public String execute(int testCases) {
		
		int dot = 0;
		char won = 'X';
		String op = "Case #" + testCases + ": " ;
		
		//Horizontal scan
		for(int i = 0; i < length; i++) {
			
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < length; j++) {
				
				sb.append(array[i][j]);
				
				if(array[i][j] == '.')
					dot++;
				else if (array[i][j] != 'T')
					won = array[i][j];
			}
			
			if(repo.contains(sb.toString())) {
				return (op + won + " won");
			}
		}
		
		//Vertical scan
		for(int i = 0; i < length; i++) {
			
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < length; j++) {
				
				sb.append(array[j][i]);
				
				if(array[j][i] == '.')
					dot++;
				else if (array[j][i] != 'T')
					won = array[j][i];
			}
			
			if(repo.contains(sb.toString())) {
				return (op + won + " won");
			}
		}
		
		//Diagonal scan1
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < length; i++) {
			sb.append(array[i][i]);
				
			if (array[i][i] != 'T' && array[i][i] != '.')
				won = array[i][i];
		}
		
		if(repo.contains(sb.toString())) {
			return (op + won + " won");
		}
		
		//Diagonal scan1
		sb = new StringBuilder();
		for(int i = 0; i < length; i++) {
			sb.append(array[length - 1 - i][i]);
				
			if (array[length - 1 - i][i] != 'T' && array[length - 1 - i][i] != '.')
				won = array[length - 1 - i][i];
		}
		
		if(repo.contains(sb.toString())) {
			return (op + won + " won");
		}
		
		
		return dot == 0 ? op + "Draw" : op + "Game has not completed";
	}
	
	public static void main(String[] args) {
		
		TicTacToe ticTacToe = new TicTacToe();
		
		String input = "C:\\PIA\\workspace_GCJ\\GCJ\\src\\com\\google\\qr2013\\input";
		String output = "C:\\PIA\\workspace_GCJ\\GCJ\\src\\com\\google\\qr2013\\output";
		
		try {
			
			Scanner sc = new Scanner(new FileReader(input));
			PrintWriter pw = new PrintWriter(output);
			
			int testCases = sc.nextInt();
			System.out.println(sc.nextLine());
			int i = 1;
			while(i <= testCases) {
				ticTacToe.getInputFromUser(sc);
				String op = ticTacToe.execute(i);
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
