/*
Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence
1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
shows the first 11 ugly numbers. By convention, 1 is included.
Write a program to find and print the 150′th ugly number.*/
package com.dp;

/**
 *
 * @author h.chandulal.lakhani
 */
public class UglyNumber {
    
    //Brute Force
    public int findUglyNo(int n) {
        int num;
        int count = 0;
        for(num = 1; count < n; num++) {
            int temp = num; 
            while(temp % 5 == 0)
                temp = temp / 5;
            while(temp % 3 == 0)
                temp = temp / 3;
            while(temp % 2 == 0)
                temp = temp / 2;
            if(temp == 1)
                count++;
        }
        return num - 1;
    }

    //DP
    public int findUglyNoDP(int n) {
        
        int[] array = new int[n];
        array[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        
        for(int i = 1; i < n; i++) {
        
            int min = min(array[i2] * 2, array[i3] * 3, array[i5] * 5);
            
            if(min == array[i2] * 2) {
                i2 = i2 + 1;
            } 
            if(min == array[i3] * 3) {
                i3 = i3 + 1;
            } if(min == array[i5] * 5){
                i5 = i5 + 1;
            }
            array[i] = min;
        }
        
        return array[n - 1];
    }
    
    private int min (int a, int b, int c) {
        
        if (a <= b) {
            if (a <= c) {
                return a;
            } else {
                return c;
            }
        }
        if (b <= c) {
            return b;
        } else {
            return c;
        }
    
        /*if(a > b) {
            if(b > c)
                return c;
            else 
                return b;
        } else {
            if(a > c)
                return c;
            else 
                return a;
        }*/
    }
     public static void main(String[] args) {

        UglyNumber obj = new UglyNumber();
        for(int i = 1; i <= 11; i++)
         System.out.print(obj.findUglyNo(i) + " ");
        System.out.println();
        for(int i = 1; i <= 11; i++)
         System.out.print(obj.findUglyNoDP(i) + " ");
    }
    
}
