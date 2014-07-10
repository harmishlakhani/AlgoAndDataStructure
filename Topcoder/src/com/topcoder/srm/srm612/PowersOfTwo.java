package com.topcoder.srm.srm612;

import java.util.HashSet;
import java.util.Set;

public class PowersOfTwo {

	Set<Long> set = new HashSet<Long>();
	long[] powers = null;
	
	public long count(long[] powers) {
		
		int length = powers.length;
		this.powers = new long[length];
		int[] s = new int[length];
		
		for(int i = 0; i < length; i++) {
			set.add(powers[i]);
			this.powers[i] = powers[i];
		}
		
		for(int i = 2; i <= length; i++) {
			generate(s, 0, 0, i,length);
		}
		
		return set.size() + 1;
	}
	
	
	private void showCombination(int[] s, int k) {
		long sum = 0;
        for (int i = 0; i < k; i++)
            sum += powers[s[i]];
        set.add(sum);
    }

	private void generate(int[] s, int position, int nextInt, int k, int N) {
        if (position == k) {
            showCombination(s, k);
            return;
        }
        for (int i = nextInt; i < N; i++) {
            s[position] = i;
            generate(s, position + 1, i + 1, k, N);
        }
    }  
    
	public static void main(String[] args) {

		PowersOfTwo obj = new PowersOfTwo();
		
		System.out.println(obj.count(new long[]{1048576,1073741824,549755813888,70368744177664,4398046511104,262144,1048576,2097152,8796093022208,1048576,1048576,35184372088832,2097152,256,256,256,262144,1048576,1048576,70368744177664,262144,1048576}));
		System.out.println(Long.MAX_VALUE);
		
		
	}

}

