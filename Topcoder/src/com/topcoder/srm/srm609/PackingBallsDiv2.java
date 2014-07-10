package com.topcoder.srm.srm609;

public class PackingBallsDiv2 {

	public int minPacks(int R, int G, int B) {
		
		int packs = 0;
		
		packs += R / 3;
		packs += G / 3;
		packs += B / 3;
		
		R = R % 3;
		G = G % 3;
		B = B % 3;
	
		/*while(R >= 3) {
			R = R - 3;
			packs++;
		}
		
		while(G >= 3) {
			G = G - 3;
			packs++;
		}
		
		while(B >= 3) {
			B = B - 3;
			packs++;
		}*/
		
		while(true) {
			
			if(R == 0 && B == 0 && G == 0)
				break;
			
			if(R + G + B >= 3) {
				R--;
				G--;
				B--;
				packs++;
			} else if(R + G + B < 3) {
				packs++;
				break;
			} 
			
				
			/*if(R > 0 && G > 0 && B > 0) {
				
			}
			
			if(G > 0)
				G--;
			
			if(B > 0)
				B--;
			
			packs++;*/
		}
		return packs;
	}
	
	
	public static void main(String[] args) {

		PackingBallsDiv2 obj = new PackingBallsDiv2();
		
		System.out.println(obj.minPacks(99, 99, 99));
		
		
	}

}

