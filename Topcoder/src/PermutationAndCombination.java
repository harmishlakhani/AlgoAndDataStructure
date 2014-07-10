public class PermutationAndCombination {

	public int combination(int n, int r) {
		return factorial(n) / (factorial(r) * factorial(n - r));
	}

	public int permutation(int i) {
		return factorial(i);
	}
	
	public int factorial(int n) {
		if(n == 1)
			return 1;
		return n * factorial(n - 1);
	}
}
