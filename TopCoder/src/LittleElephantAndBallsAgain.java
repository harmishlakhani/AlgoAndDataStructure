public class LittleElephantAndBallsAgain {

	
	int getNumber(String S) {
		
		char[] array = S.toCharArray();
		int length = array.length;
		int maxLength = 0;
		int index = 0;
		
		for(int i=0; i < length; i++) {
			
			index = i;
			int j = i+1;
			while(j<length && array[index] == array[j])
				j++;
			if((j - index) > maxLength)
				maxLength = j - index;
		}
		
		return length - maxLength;
	}
	
	
	public static void main(String[] args) {

		System.out.println("hello world!!");

		
		LittleElephantAndBallsAgain obj = new LittleElephantAndBallsAgain();
		
		System.out.println("hello world!! + " + obj.getNumber("RRGGGB"));
		
		
	}

}
