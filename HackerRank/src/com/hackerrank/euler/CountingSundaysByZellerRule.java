package com.hackerrank.euler;

/**
 * http://mathforum.org/dr.math/faq/faq.calendar.html
 * http://mathforum.org/library/drmath/view/62324.html
 * https://github.com/nayuki/Project-Euler-solutions/blob/master/java/p019.java
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountingSundaysByZellerRule {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for (int a = 0; a < t; a++) {

			int counter = 0;
			String in[] = br.readLine().split(" ");
			long Y1 = Long.parseLong(in[0]);
			long M1 = Long.parseLong(in[1]);
			long D1 = Long.parseLong(in[2]);

			in = br.readLine().split(" ");
			long Y2 = Long.parseLong(in[0]);
			long M2 = Long.parseLong(in[1]);
			long D2 = Long.parseLong(in[2]);

			if (Y1 == Y2 && M1 == M2 && (D1 == 1 || D2 == 1)) {
				if (zellerRule(Y1, M1, 1) == 1)
					counter++;
				System.out.println(counter);
				continue;
			}
			
			if (D1 != 1)
				M1++;
			
			if(Y1 == Y2){
				for (int mon = (int) M1; mon <= (int)M2; mon++) {
					if (zellerRule(Y1, mon, 1) == 1)
						counter++;
				}
				System.out.println(counter);
				continue;
			}
			
			for (int mon = (int) M1; mon <= 12; mon++) {
				if (zellerRule(Y1, mon, 1) == 1)
					counter++;
			}

			for (long i = Y1 + 1; i < Y2; i++) {
				for (long j = 1; j <= 12; j++) {
					if (zellerRule(i, j, 1) == 1)
						counter++;
				}
			}

			for (int mon = 1; mon <= (int) M2; mon++) {
				if (zellerRule(Y2, mon, 1) == 1)
					counter++;
			}
			System.out.println(counter);
		}
	}

	public static long zellerRule(long year, long month, long day) {

		if (month < 3) {
			month += 12;
			year--;
		}

		long d = year % 100;
		long c = year / 100;

		// long f = day + (long)Math.floor((13 * month - 1) / 5) + d +
		// (long)Math.floor(d / 4) + (long)Math.floor(c / 4) - (2 * c);
		long f = day + (26 * (month + 1) / 10) + d + (d / 4) + (c / 4)
				+ (5 * c);
		// long f = day + (26 * (month + 1) / 10) + year + (year / 4) + (6 *
		// (year / 100)) + ((year / 400));

		long reminder = f % 7;

		/*
		 * if(f < 0 && reminder > 0) { reminder = reminder + 7; }
		 */

		return reminder;
	}
}