package com.hackerrank.euler;

/**
 * http://mathforum.org/library/drmath/view/55811.html
 * http://pastebin.com/sciWr4j2
 * 
 * substitute c = N - a - b from a + b + c = N to a2 + b2 = c2;
 * b = N2 - 2Na / 2(N - a)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpecialPythagoreanTriplet {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int testCase = 0; testCase < t; testCase++) {
			int max = -1;
			int N = Integer.parseInt(br.readLine());

			for (int a = 1; a <= N / 2; a++) {

				if (((N * N) - (2 * N * a)) % (2 * (N - a)) == 0) {
					int b = ((N * N) - (2 * N * a)) / (2 * (N - a));
					if(b > 0) {
						if ((a * a + b * b) == (N - a - b) * (N - a - b)) {
							int mul = a * b * (N - a - b);
							if (mul > max) {
								max = mul;
							}
						}
					}
					
				}
			}
			System.out.println(max);
		}
	}
}