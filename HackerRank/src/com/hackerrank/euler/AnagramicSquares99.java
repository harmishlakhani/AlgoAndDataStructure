package com.hackerrank.euler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AnagramicSquares99 {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long[][] pairs = new long[n][2];
		double[][] digits = new double[n][2];
		
		for (int a = 0; a < n; a++) {
			
			String[] array = br.readLine().split(" ");
			int b = Integer.parseInt(array[0]);
			int e = Integer.parseInt(array[1]);
			
			pairs[a][0] = b;
			pairs[a][1] = e;
			
			digits[a][0] = a;
			digits[a][1] = smallNo(b, e);
		}		
		
		int k = Integer.parseInt(br.readLine());

		/*int i, j, minIndex;
		double tmp;
		int length = digits.length;
		for (i = 0; i < length - 1; i++) {
			minIndex = i;
			for (j = i + 1; j < length; j++)
				if (digits[j][1] < digits[minIndex][1])
					minIndex = j;
			if (minIndex != i) {
				tmp = digits[i][1];
				digits[i][1] = digits[minIndex][1];
				digits[minIndex][1] = tmp;

				tmp = digits[i][0];
				digits[i][0] = digits[minIndex][0];
				digits[minIndex][0] = tmp;
			}
		}*/

		/*for(i = 0; i < n; i++)
			System.out.println(digits[i][0] + " : " + digits[i][1]);*/
		
		MyQuickSort sort = new MyQuickSort();
		sort.sort(digits);
		System.out.println(pairs[(int) digits[k-1][0]][0] + " " + pairs[(int) digits[k-1][0]][1]);
	}
	
	public static long noOfDigit(int base, int exp) {
		return (long) (1 + (exp * Math.log10(base)));
	}
	
	public static double smallNo(int base, int exp) {
		return (exp * Math.log10(base));
	}
}

class MyQuickSort {
    
    private double array[][];
    private int length;
 
    public void sort(double[][] inputArr) {
         
        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        this.array = inputArr;
        length = inputArr.length;
        quickSort(0, length - 1);
    }
 
    private void quickSort(int lowerIndex, int higherIndex) {
         
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        double pivot = array[lowerIndex+(higherIndex-lowerIndex)/2][1];
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (array[i][1] < pivot) {
                i++;
            }
            while (array[j][1] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }
 
    private void exchangeNumbers(int i, int j) {
        double temp = array[i][1];
        array[i][1] = array[j][1];
        array[j][1] = temp;
        
        temp = array[i][0];
        array[i][0] = array[j][0];
        array[j][0] = temp;
    }
}