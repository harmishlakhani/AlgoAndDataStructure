/*
 
Problem Statement
    
Little John has a piece of paper with some distinct integers written on it. You are given a int[] numbers. The elements of numbers are the numbers written on John's paper.
  
John is now going to add some new numbers to his paper. While doing so, he will be using integer division. When doing integer division, we discard the fractional part of the result. In this problem, we will use "div" to denote integer division. For example, 15 div 5 = 3, and 24 div 5 = 4.
  
John will repeat the following process: He will look at his paper and select two distinct numbers A and B such that A is greater than B. He will compute C = A div B. If C is not written on his paper yet, he will add it to the paper.
  
The process will stop once there is no way for John to add a new number to his paper. Compute and return how many numbers will there be on John's paper at the end.
  
Definition
    
Class:
DivideByZero
Method:
CountNumbers
Parameters:
int[]
Returns:
int
Method signature:
int CountNumbers(int[] numbers)
(be sure your method is public)
Limits
    
Time limit (s):
2.000
Memory limit (MB):
256
Notes
-
The return value does not depend on the order in which John adds new numbers to his paper.
Constraints
-
numbers will contain between 1 and 100 elements, inclusive.
-
Each element of numbers will be between 1 and 100, inclusive.
-
The elements in numbers will be distinct.
Examples
0)

    
{9, 2}
Returns: 3
John starts with just 9 and 2 on his paper. He can add the number 4, because 9 div 2 = 4. After he adds the number 4, there will be no more numbers to add, because 9 div 4 = 2, and also 4 div 2 = 2. Thus, at the end John's paper will contain 3 numbers: 9, 2, and 4.
1)

    
{8, 2}
Returns: 3

2)

    
{50}
Returns: 1
We only have one number. There isn't anything John can do.
3)

    
{1, 5, 8, 30, 15, 4}
Returns: 11

4)

    
{1, 2, 4, 8, 16, 32, 64}
Returns: 7

5)

    
{6, 2, 18}
Returns: 7
Once John has a number on his paper, he can use it when producing new numbers. For example, in this case he can add 9 (computed as 18 div 2), and then add 1 (computed as 9 div 6). The numbers he will have at the end are 1, 2, 3, 4, 6, 9, and 18.
This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
 */
package com.topcoder.srm.srm610;

import java.util.Arrays;

public class DivideByZero {
	
	public int CountNumbers(int[] numbers) {
		
		int lenght = numbers.length;
		Arrays.sort(numbers);
		
		for(int i = 0; i < lenght; i++) {
		
			int index = 0;
			int[] numbersCopy = new int[100];
			for(int j = i + 1; j < lenght; j++) {
				
				int temp = numbers[j] / numbers[i];
				boolean flag = false;
				
				for(int k = 0; k < lenght; k++) {
					if(numbers[k] == temp) {
						flag = true;
						break;
					}
				}
				
				if(!flag) {
					numbersCopy[index] = temp;
					index++;
				}
				
			}
			
			for(int b = 0; b < index; b++) {
				if(numbersCopy[b] < numbers[i]) {
					i = -1;
					break;
				}
			}
			
			for(int a = 0; a < lenght; a++)
				numbersCopy[a + index] = numbers[a];
			
			numbers = Arrays.copyOf(numbersCopy, index + lenght);
			Arrays.sort(numbers);
			lenght = numbers.length;
		}
		
		System.out.println(lenght);
		System.out.println(numbers);
		
		
		return lenght;
	}
				
	public static void main(String[] args) {

		DivideByZero obj = new DivideByZero();
		
		System.out.println(obj.CountNumbers(new int[] {9, 2}));
		
		
	}

}

