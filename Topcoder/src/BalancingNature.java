public class BalancingNature {

	
	public static void main(String[] args) {

		int n = Integer.parseInt(args[0]);		
		int min = n;
		long temp[] = new long[n];
		int count = 0;
		
		for(int i=0; i < n; i++) {
			temp[i] = Long.parseLong(args[i+1]);
		}

		for(int i = 0; i < n; i++) {
			
			count = 0;
			for(int j=0; j <= i; j++) {
				if(temp[j] >= 0)
					count++;
			}
			
			for(int k=i+1; k < n; k++) {
				if(temp[k] <= 0)
					count++;
			}
			
			if(min > count)
				min = count;
		}
		
		System.out.println(min);
	}

}
