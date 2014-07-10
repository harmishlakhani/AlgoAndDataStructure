/*
Problem Statement
Fox Ciel is staying in Linear Country for sightseeing. The country consists of N cities numbered 0 through N-1. Ciel is currently staying in city 0.

In this problem, we assume that the country is a straight line and that each city is a point on this line. You are given a int[] position with N elements. The i-th element in position represents the coordinate of the city i. The cities are numbered arbitrarily, their numbers are not related to their positions. Thus, distance between city i and city j is |position[i] - position[j]|, where |z| represents the absolute value of z.

Ciel wanted to visit all the cities, so she planned a tour. She was going to visit city 0 on day 1, visit city 1 on day 2, and so on. She wanted to terminate the tour upon arrival to city N-1.

Unfortunately, it turned out that Ciel's holiday has to be one day shorter. Of course, she must still start in city 0 and end in city N-1, so she decided to skip one of the other N-2 cities (i.e., one of cities 1 through N-2). She still wants to visit the other cities in the order given by their numbers. For example, if N=5, Ciel has three possibilities for her holiday: she will visit the cities in one of the orders (0,1,2,4), (0,1,3,4), or (0,2,3,4).

Among these possibilities, Ciel will choose the one where the total distance she will have to travel is minimized. Compute and return this minimum total distance.
 
Definition
    	
Class:	FoxAndSightseeing
Method:	getMin
Parameters:	int[]
Returns:	int
Method signature:	int getMin(int[] position)
(be sure your method is public)
    
 
Notes
-	You are not given the value of N, but you can easily determine it: N is equal to the number of elements in position.
 
Constraints
-	position will contain between 3 and 50 elements, inclusive.
-	Each element of position will be between -100 and 100, inclusive.
-	All the elements in position will be distinct.
 
Examples
0)	
    	

{1, 4, -1, 3}

Returns: 4

There are two strategies for Ciel.

    Skip city 1. The total distance is |1-(-1)|+|(-1)-3| = 2+4 = 6.
    Skip city 2. The total distance is |1-4|+|4-3| = 3+1 = 4.

The second choice is better. So you should output 4.
1)	
    	

{-2, 4, 3}

Returns: 5

There is only one strategy for Ciel: She skips city 1. The total distance is |(-2)-3| = 5.
2)	
    	

{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}

Returns: 9

For any choice she makes, the total distance is 9.
3)	
    	

{100, -100, 99, -99}

Returns: 199

The optimum strategy is to skip city 1.
4)	
    	

{74,84,92,23,5,-70,-47,-59,24,-86,-39,99,85,-42,54,100,47,-3,42,38}

Returns: 836

5)	
    	

{2,-3,5,7,-11,-13,17,-19,23,29,-31,-37,-41,43,-47,-53,-59,61,-67,71}

Returns: 535
 */

package com.topcoder.srm.srm608;

import java.util.Arrays;

public class MysticAndCandiesEasy {

	int array[];
	
	public int minBoxes(int C, int X, int[] high) {
		
		int length = high.length;
		
		if(length == 1)
			return 1;
		
		array = new int[length]; 
		Arrays.sort(high);
		int total = 0;
		int index = 0;
		int capacity = 0;
		
		while(total < C) {
			
			capacity = high[index] - array[index];
			
			for(int i = 0; i < length && total < C; i++) {
				if(array[i] + capacity <= high[i]) {
					array[i] += capacity;
					total += capacity;
				}
			}
			index++;
		}
		
		Arrays.sort(array);
		total = 0;
		int count = 0;
		for(int i = length - 1; i >= 0 && total < X; i--) {
			total += array[i];
			count++;
		}
		
		return count;
	}
				
	public static void main(String[] args) {

		MysticAndCandiesEasy obj = new MysticAndCandiesEasy();
		
		System.out.println(obj.minBoxes(326, 109, new int[]{9, 13, 6, 6, 6, 16, 16, 16, 10, 16, 4, 3, 10, 8, 11, 17, 12, 5, 7, 8, 7, 4, 15, 7, 14, 2, 2, 1, 17, 1, 7, 7, 12, 17, 2, 9, 7, 1, 8, 16, 7, 4, 16, 2, 13, 3, 13, 1, 17, 6}));
		
		
	}

}

