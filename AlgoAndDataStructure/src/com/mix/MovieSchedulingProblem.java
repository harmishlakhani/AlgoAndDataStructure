/*
Problem definition
You take your friend to a multiplex and she wants to have a movie-marathon with you. She gives you a list of movies with their start time and the end time and you have to figure out the maximum number of movies you can watch. Assume the list contains all distinct movies. Each movie that you watch has to be watched completely. The start and end timings are giving to you as two integer arrays.
Sample Case:
Input:
movie_start [] = {10, 12, 9, 14, 16, 14}
movie_end []   = {11, 13, 15, 16, 18, 18}
Output:
4
Explanation: 
Maximum movies that can be watched: (10-11), (12-13), (14-16) and (16-18). 
Therefore, maximum of 4 movies.*/
package com.mix;

public class MovieSchedulingProblem {

	public static void count(int[] start, int[] end) {
		
		int length = start.length;
		int[][] array = new int[length][length];
		int tempIndex;
		for(int i = 0; i < length; i++) {
			tempIndex = i;
			for(int j = i + 1; j < length; j++) {
				if(end[tempIndex] > end[j])
					tempIndex = j;
			}
			array[i][0] = start[tempIndex];
			array[i][1] = end[tempIndex];
		}
		
		for(int i = 0; i < length; i++) {
			
			if(array[i][1] == -1)
				continue;
			for(int j = i + 1; j < length; j++) {
				if(array[j][0] < array[i][1]) {
					array[j][0] = -1;
					array[j][1] = -1;
				}
			}
		}
		
		int count = 0;
		for(int i = 0; i < length; i++) {
			if(array[i][0] == -1)
				continue;
			System.out.println(array[i][0] + " " + array[i][1]);
			count++;
		}
		System.out.println("Count is " + count);
	} 
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		count(new int[] {10, 12, 9, 14, 16, 14}, new int[] {11, 13, 15, 16, 18, 18});
		count(new int[] {6, 6, 7, 10, 12, 9, 14, 16, 14}, new int[] {8, 10, 10, 11, 13, 15, 16, 18, 18});
	}

}
