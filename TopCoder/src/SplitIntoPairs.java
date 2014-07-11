import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

public class SplitIntoPairs {

	
	public int makepairs(int[] A, int X) {
		
		Arrays.sort(A);
		int count = 0;
		
		for(int i = 0; i < A.length; i += 2) {
			if((A[i] >= 0 && A[i+1] >= 0) || (A[i] < 0 && A[i+1] < 0))
				count++;
			else{ 
				int temp = A[i];
				if(temp > A[i+1])
					temp = A[i+1];
				
				if(temp >= X){
					
					long ai = A[i];
					long ai1 = A[i+1];
					long prod = ai * ai1;
					System.out.println(prod);
					if(prod >= X)
						count++;
				}
			};
		}
		return count;
	}
	
	
	public static void main(String[] args) {

		SplitIntoPairs obj = new SplitIntoPairs();
		
		System.out.println( obj.makepairs(new int[]{-5, 140, 94, -45, -136, -139, 193, 125, -117, 97, -87, -111, 199, 0, 43, 135, -37, 32, -62, 170, -50, -71}, -1));
		
		
	}
}
