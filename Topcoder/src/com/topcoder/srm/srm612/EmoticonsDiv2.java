package com.topcoder.srm.srm612;

public class EmoticonsDiv2 {

	public int printSmiles(int smiles) {
		
		int no = 0;
		for(int i = 2; i <= smiles; i++) {
			if(smiles % i == 0) {
				int count = 0;
				while(smiles % i == 0) {
					smiles = smiles / i;
					count++;
				}
				no += i * count;
			}
		}
		
		return no;
	}
	
	
	
	public static void main(String[] args) {

		EmoticonsDiv2 obj = new EmoticonsDiv2();
		
		System.out.println(obj.printSmiles(1000));
		
		
	}

}

