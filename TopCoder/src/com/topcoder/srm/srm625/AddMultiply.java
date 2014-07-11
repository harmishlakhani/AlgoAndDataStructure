package com.topcoder.srm.srm625;


public class AddMultiply {

	public int[] makeExpression(int y) {

		int[] array = new int[3];
		
		outer:
		for(int i = 2; i <= 1000; i++) {
			array[2] = i;
			for(int j = 2; j <= 1000; j++) {
				if((y - array[2]) % j == 0) {
					int temp = (y - array[2]) / j;
					
					if(temp == 0 || temp == 1)
						break;
					
					array[0] = temp;
					array[1] = j;
					break outer;
				}
			}
		}
		
		return array;
	}

	public static void main(String[] args) {

		AddMultiply obj = new AddMultiply();

		int[] temp = obj.makeExpression(5);
		
		for(int i = 0; i < 3; i++)
			System.out.print(temp[i] + "  ");

	}

}
