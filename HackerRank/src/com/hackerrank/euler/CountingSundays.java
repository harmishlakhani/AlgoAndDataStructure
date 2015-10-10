package com.hackerrank.euler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CountingSundays {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] months = populateMonths();
		Map<Integer, String> map = populateWeekDays();
		
		int t = Integer.parseInt(br.readLine());
		for (int a = 0; a < t; a++) {

			String in[] = br.readLine().split(" ");
			long Y1 = Long.parseLong(in[0]);
			long M1 = Long.parseLong(in[1]);
			long D1 = Long.parseLong(in[2]);
			
			in = br.readLine().split(" ");			
			long Y2 = Long.parseLong(in[0]);
			long M2 = Long.parseLong(in[1]);
			long D2 = Long.parseLong(in[2]);
			
			/*Calendar c = Calendar.getInstance();
			c.setTime(new Date((int)Y1, (int)M1, (int)D1));
			int day = c.get(Calendar.DAY_OF_WEEK);*/
			
			long counter = 0;
			int prevDay = 0;
			boolean flag = isLeapYear(1900);
			
			if(Y1 > 1900) {
				for(long i = 1900; i < Y1; i++) {
					
					flag = isLeapYear(i);
					
					for(int mon = 1; mon <= 12; mon++) {
						int reminder = months[mon] % 7;
						if(flag && mon == 2) {
							reminder++;
						}
						int day = prevDay + reminder > 6 ? prevDay + reminder - 7 : prevDay + reminder;
						prevDay = day;
					}
				}
			}
			
			flag = isLeapYear(Y1);
			
			if(D1 != 1)
				M1++;
			
			for(int mon = (int)M1; mon <= 12; mon++) {
				int reminder = months[mon] % 7;
				if(flag && mon == 2) {
					reminder++;
				}
				int day = prevDay + reminder > 6 ? prevDay + reminder - 7 : prevDay + reminder;
				//System.out.println(map.get(day));
				if(day == 6)
					counter++;
				prevDay = day;
			}
			
			for(long i = Y1 + 1; i < Y2; i++) {
				
				flag = isLeapYear(i);
				
				for(int mon = 1; mon <= 12; mon++) {
					int reminder = months[mon] % 7;
					if(flag && mon == 2) {
						reminder++;
					}
					int day = prevDay + reminder > 6 ? prevDay + reminder - 7 : prevDay + reminder;
					//System.out.println(map.get(day));
					if(day == 6)
						counter++;
					prevDay = day;
				}
			}
			
			flag = isLeapYear(Y2);
			for(int mon = 1; mon <= (int)M2; mon++) {
				int reminder = months[mon] % 7;
				if(flag && mon == 2) {
					reminder++;
				}
				int day = prevDay + reminder > 6 ? prevDay + reminder - 7 : prevDay + reminder;
				//System.out.println(map.get(day));
				if(day == 6)
					counter++;
				prevDay = day;
			}
			System.out.println(counter);
		}
	}

	private static int[] populateMonths() {
		
		int[] months = new int[14];
		
		months[1] = 31;
		months[2] = 28;
		months[3] = 31;
		months[4] = 30;
		months[5] = 31;
		months[6] = 30;
		months[7] = 31;
		months[8] = 31;
		months[9] = 30;
		months[10] = 31;
		months[11] = 30;
		months[12] = 31;
		months[13] = 29;
		
		return months;
	}
	
	private static Map<Integer, String> populateWeekDays() {
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(0, "Monday");
		map.put(1, "Tuesday");
		map.put(2, "Wednesday");
		map.put(3, "Thursday");
		map.put(4, "Friday");
		map.put(5, "Saturday");
		map.put(6, "Sunday");
		
		return map;
	}
	
	public static boolean isLeapYear(long year) {
		if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
			return true;
		return false;
	}
}