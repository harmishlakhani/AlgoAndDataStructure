package com.topcoder.srm.srm617;


public class SilverbachConjecture {
	
	public int[] solve(int n) {
		
		int[] array = new int[2];
		
		for(int i = 2; i < n - 2; i++) {
			
			int temp1 = i;
			int temp2 = n - i;
			boolean flag1 = false;
			boolean flag2 = false;
			
			int index = 2;
			while(temp1 > 1 && index < temp1) {
				if(temp1 % index == 0) {
					flag1 = true;
					break;
				} else {
				//	temp1 = temp1 / index;
					index++;
				}
			}
			
			index = 2;
			while(temp2 > 1 && index < temp2) {
				if(temp2 % index == 0) {
					flag2 = true;
					break;
				} else {
					//temp2 = temp2 / index; 
					index++;
				}
				
			}
			
			if(flag1 && flag2) {
				array[0] = i;
				array[1] = n - i;
				break;
			}
		}
		return array;
	}
				
	public static void main(String[] args) {

		SilverbachConjecture obj = new SilverbachConjecture();
		int[] array = obj.solve(999);
		System.out.println(array[0] + " " + array[1]);
	}

}

