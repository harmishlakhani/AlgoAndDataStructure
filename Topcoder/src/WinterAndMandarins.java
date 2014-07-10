public class WinterAndMandarins {

	public int getNumber(int[] bags, int K) {
		
		int combination = combination(bags.length, K);
		System.out.println(combination);
		
		for(int i = 0; i < combination; i++) {
			
		}
		return 0;
	}
	
	private int combination(int n, int k) {
		return permutation(n) / (permutation(k) * permutation(n - k));
	}

	private int permutation(int i) {
		if (i == 1) {
			return 1;
		}
		return i * permutation(i - 1);
	}
	
	public static void main(String[] args) {

		WinterAndMandarins obj = new WinterAndMandarins();
		
		System.out.println(obj.getNumber(new int[]{10,20,30,40}, 3));
		
		
	}

}
