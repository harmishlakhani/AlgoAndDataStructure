package com.topcoder.srm.srm613;

public class TaroString {
	
	public String getAnswer(String S) {
		
		for(int i = 0; i < 26; i++) {
			
			char a = (char) (i + 65);
			
			if(i == 0 || i == 2 || i == 19)
				continue;
			
			S = S.replaceAll(String.valueOf(a), "");
			
		}
		System.out.println(S);
		if(S.equals("CAT"))
			return "Possible";
		
		return "Impossible";
	}
				
	public static void main(String[] args) {

		TaroString obj = new TaroString();
		 
		System.out.println(obj.getAnswer("SGHDJHFIOPUFUHCHIOJBHAUINUIT"));
		
		
	}

}

