public class TypoCoderDiv2 {

	public int getmax(int[] X, int[] Y, int limit) {
		
		int length = X.length;
		int count = 0;
		int min = 0;
		int minX = 0;
		int minY = 0;
		int product = 0;
		int minProduct = X[0] * Y[0];
		
		for(int i = 0; i < length; i++) {
			product = X[i] * Y[i];
			if(product >= limit) {
				min = i;
				minProduct = product;
				break;
			}
		}
		for(int i = 0; i < length; i++) {
			
			product = X[i] * Y[i];
			if(product >= limit) {
				
				minX = min(X[i], X[min]);
				minY = min(Y[i], Y[min]);
				
				if(minX * minY >= limit) {
					count++;
					if(product < minProduct) {
						min = i;
						minProduct = product;
					}
				}
				else {
					minX = min(X[i], Y[min]);
					minY = min(Y[i], X[min]);
					
					if(minX * minY >= limit) {
						count++;
						if(product < minProduct) {
							min = i;
							minProduct = product;
						}
					}
				}
			}
			else
				continue;
		}
		
		if(count == 0)
			count = -1;
		return count;
	}
	
	private int min(int a, int b) {
		
		if(a > b)
			return b;
		else 
			return a;
	}
	
	public static void main(String[] args) {

		TypoCoderDiv2 obj = new TypoCoderDiv2();
		System.out.println(obj.getmax(new int[] {24, 9, 11, 36, 74, 198, 100, 127, 10, 106, 159, 182, 148, 151, 22, 185, 99, 181, 6, 128, 158, 73, 33, 174, 185, 26},new int[] {145, 72, 57, 79, 129, 15, 103, 2, 34, 105, 155, 29, 26, 167, 37, 128, 172, 154, 108, 152, 182, 3, 102, 122, 65, 158}, 3511));
	}

}
