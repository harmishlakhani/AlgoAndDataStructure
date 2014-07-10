import java.util.Arrays;

public class BigFatInteger2 {

	public String isDivisible(int A, int B, int C, int D) {

		if(B == D) {
			if(A % C == 0)
				return "divisible";
		}
		
		if(A == C) {
			if(B > D)
				return "divisible";
		}
		
		/*if((A != C) && isPrime(A) && isPrime(C))
			return "not divisible";*/
		
		if(Math.pow(A, B) % Math.pow(C, D) == 0)
			return "divisible";
		
		return "not divisible";
	}

	private boolean isPrime(int n) {
		
		if(n == 2)
			return true;
		
		int i, res;
		boolean flag = true;
		for(i=2;i<=Math.sqrt(n);i++)
		{
			res=n%i;
			if(res==0)
			{
				flag=false;
				break;
			}
		}
		return flag;
			
	}
	public static void main(String[] args) {

		BigFatInteger2 obj = new BigFatInteger2();

		System.out.println("hello world!! + "+ obj.isDivisible(8,100,4,200));

	}

}
