/*
There is a one-dimensional road. The road is separated into N consecutive parts. The parts are numbered 0 through N-1, in order. Ciel is going to walk from part 0 to part N-1.

Ciel also noticed that each part of the road has a color: either red, green, or blue. Part 0 is red.

Ciel is going to perform a sequence of steps. Each step must lead in the positive direction. That is, if her current part is i, the next step will take her to one of the parts i+1 through N-1, inclusive. Her steps can be arbitrarily long. However, longer steps are harder: a step of length j costs j*j energy.

Additionally, Ciel wants to step on colors in a specific order: red, green, blue, red, green, blue, ... That is, she starts on the red part 0, makes a step to a green part, from there to a blue part, and so on, always repeating red, green, and blue in a cycle. Note that the final part N-1 also has some color and thus Ciel must reach it in a corresponding step.

You are given a String road containing N elements. For each i, element i of road is the color of part i: 'R' represents red, 'G' green, and 'B' blue. If Ciel can reach part N-1 in the way described above, return the smallest possible total cost of doing so. Otherwise, return -1.
 
Definition
    	
Class:	ColorfulRoad
Method:	getMin
Parameters:	String
Returns:	int
Method signature:	int getMin(String road)
(be sure your method is public)
    
 
Constraints
-	road will contain between 2 and 15 characters, inclusive.
-	Each character of road will be either 'R' or 'G' or 'B'.
-	The first character of road will be 'R'.
 
Examples
0)	
    	

"RGGGB"

Returns: 8

The optimum solution is to step part 0 -> part 2 -> part 4. The total cost is 2*2 + 2*2 = 8.
1)	
    	

"RGBRGBRGB"

Returns: 8

The optimum solution is to make steps of length 1. It costs 1*1 = 1 per each step, so the total cost is 8.
2)	
    	

"RBBGGGRR"

Returns: -1

It is impossible to reach the destination.
3)	
    	

"RBRRBGGGBBBBR"

Returns: 50

4)	
    	

"RG"

Returns: 1

5)	
    	

"RBRGBGBGGBGRGGG"

Returns: 52 */

package com.topcoder.srm.srm608;


public class OneDimensionalRobotEasy {

	
	public int finalPosition(String commands, int A, int B) {
		
		int position = 0;
	
		for(int i = 0; i < commands.length(); i++) {
			
			if(commands.charAt(i) == 'R') {
				if(position < B)
					position++;
			}
			else if(commands.charAt(i) == 'L') {
				if(position > (-1) * A)
					position--;
			}
		}
		return position;
	}
	
	
	public static void main(String[] args) {

		OneDimensionalRobotEasy obj = new OneDimensionalRobotEasy();
		
		System.out.println(obj.finalPosition("RRRRRRRLRRLRRRRRRRRRRRRLRLRRRRRRRRLRRRRRLRRRRRRRRR", 5, 20));
		
		
	}

}

