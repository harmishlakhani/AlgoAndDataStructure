
public class ErasingCharacters {

	
	String simulate(String s) {
		
		StringBuilder src = new StringBuilder(s);
		int length = src.length();
		boolean flag = false;

		while(true) {
			flag = false;
			for(int i = 0; i < length-1; i++) {
				if(src.charAt(i) == src.charAt(i+1)) {
					src.deleteCharAt(i);
					src.deleteCharAt(i);
					flag = true;
					break;
				}
			
			}
			length = src.length();
			if(!flag)
				break;
		}
		return src.toString();
	}
	
	
	public static void main(String[] args) {

		System.out.println("hello world!!");

		
		ErasingCharacters obj = new ErasingCharacters();
		
		System.out.println("hello world!! + " + obj.simulate("topcoder"));
		
		
	}

}
