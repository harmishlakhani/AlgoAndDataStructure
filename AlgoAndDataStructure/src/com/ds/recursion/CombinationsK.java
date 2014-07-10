package com.ds.recursion;

class CombinationsK {

	public static void combinations(String prefix, String s, int k) {
		if(prefix.length() == k)
			System.out.println(prefix);
		
		for(int i = 0; i < s.length(); i++)
			combinations(prefix + s.charAt(i), s.substring(i+1), k);
	}	
	
	private static void showCombination(int[] s) {
        for (int i = 0; i < s.length; i++)
            System.out.print(s[i] + " ");
        System.out.println();
    }

    public static void generate(int[] s, int position, int nextInt, int k, int N) {
        if (position == k) {
            showCombination(s);
            return;
        }
        for (int i = nextInt; i < N; i++) {
            s[position] = i;
            generate(s, position + 1, i + 1, k, N);
        }
    }  
    
	public static void main(String[] args) {	
		//StringBuilder binary = new StringBuilder();
		//CombinationsK.combinations("", "abc", 3);
		//System.out.println(binary);
		CombinationsK.generate(new int[]{1,2,3,4,5}, 0, 0, 4, 5);
	}
}
