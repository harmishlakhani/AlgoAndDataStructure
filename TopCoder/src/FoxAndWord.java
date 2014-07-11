public class FoxAndWord {

	
	public int howManyPairs(String[] words) {
		
		int length = words.length;
		int count = 0;
		
		for(int i = 0; i < length; i++) {
		
			for(int j = i + 1; j < length; j++) {
				
				if(words[i].length() == words[j].length()) {
					
					for(int k = 0; k < words[i].length(); k++){
						
						String firstI = words[i].substring(0, k);
						String lastI = words[i].substring(k);
						
						String firstJ = words[j].substring(0,words[j].length() - k);
						String lastJ = words[j].substring(words[j].length() - k);
						
						if(firstI.equals(lastJ) && firstJ.equals(lastI)) {
							count++;
							break;
						}
					}
				}
			}
		}
			
		return count;
	}
	
	
	public static void main(String[] args) {

		FoxAndWord obj = new FoxAndWord();
		
		System.out.println(obj.howManyPairs(new String[]{"aa","bbb"}));
		
		
	}

}

