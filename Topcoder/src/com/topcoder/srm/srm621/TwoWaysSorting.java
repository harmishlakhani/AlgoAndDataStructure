package com.topcoder.srm.srm621;

public class TwoWaysSorting {
	
	public String sortingMethod(String[] stringList) {
		
		boolean lexicographically = true;
		boolean lengths = true;
		int length = stringList.length;
		
		if (length == 1)
			return "both";
		
		for(int i = 0; i < length - 1; i++) {
			if(stringList[i+1].length() < stringList[i].length()) {
				lengths = false;
				break;
			}
		}
		

		outer:
		for(int i = 0; i < length - 1; i++) {
			String str1 = stringList[i];
			String str2 = stringList[i + 1];
			int l1 = stringList[i].length();
			int l2 = stringList[i+1].length();
			for(int j = 0; j < l1 && j < l2; j++) {
				if(str1.charAt(j) > str2.charAt(j)) {
					lexicographically = false;
					break outer;
				}
			}
			
		}
		
		if(lexicographically && lengths)
			return "both";
		else if(lengths)
			return "lengths";
		else if(lexicographically)
			return "lexicographically";
		else
			return "none";
	}
				
	public static void main(String[] args) {

		TwoWaysSorting obj = new TwoWaysSorting();
		System.out.println(obj.sortingMethod(new String[]{"z"}));
	}

}
