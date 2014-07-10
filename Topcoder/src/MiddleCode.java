public class MiddleCode {

	
	public String encode(String s) {
		
		
		StringBuilder t = new StringBuilder();
		StringBuilder str = new StringBuilder(s);
		int length = str.length();

		while(length != 0) {
			
			if(length % 2 != 0) {
				t.append(str.charAt(length / 2));
				str.deleteCharAt(length / 2);
			}
			else {
				int n = length / 2;
				char a = str.charAt(n - 1);
				char b = str.charAt(n);
				
				if(a < b) {
					t.append(str.charAt(n - 1));
					str.deleteCharAt(n - 1);
				}
				else {
					t.append(str.charAt(n));
					str.deleteCharAt(n);
				}
					
			}
			
			length = str.length();
		}
			
		return t.toString();
	}
	
	
	public static void main(String[] args) {

		MiddleCode obj = new MiddleCode();
		
		System.out.println( obj.encode("adafaaaadafawafwfasdaa"));
		
		
	}
}
