package com.dp;

public class LongestSubstringWithoutRepeatingChars {

	public void longestSubStringWithoutRepChars(String a) {
	
		int[] visited = new int[26];
		char[] array = a.toCharArray();
		int max = 1;
		int cur_max = 1;
		int prev_index, end = 0;
		visited[array[0] - 65] = 0;
		
		for(int i = 1; i < 26; i++)
			visited[i] = -1;
			
		for(int i = 1; i < array.length; i++) {
			
			prev_index = visited[array[i] - 65];
			
			if(prev_index == - 1 || i - prev_index > cur_max)
				cur_max++;
			else {
				if(cur_max > max) {
					max = cur_max;
					end = i; 
				}
				cur_max = i - prev_index; 
			}
			
			visited[array[i] - 65] = i;
		}
		
		if(cur_max > max) {
			max = cur_max;
			end = array.length - 1;
		}
		
		System.out.println("Max length is : " + max);
		System.out.println(a.substring(end - max + 1, end + 1));
	}
	
	public static void main(String[] args) {
		
		LongestSubstringWithoutRepeatingChars obj = new LongestSubstringWithoutRepeatingChars();
		
		obj.longestSubStringWithoutRepChars("ABCD");
		obj.longestSubStringWithoutRepChars("AAAA");
		obj.longestSubStringWithoutRepChars("GEEKSFORGEEKS");
		

	}
}
