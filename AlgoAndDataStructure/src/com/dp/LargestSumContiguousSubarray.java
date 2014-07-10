/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dp;

/**
 *
 * @author h.chandulal.lakhani
 */
public class LargestSumContiguousSubarray {

    //int[] table;
    //int[] prev;
    
    //from geekForGeek
    public void largestSumSubArray(int[] array) {
        
        int max_so_far = array[0];
        int cur_max = array[0];
        int start = 0, end = 0;
        int tempStart = 0, tempEnd = 0;
        
        for(int i = 1; i < array.length; i++) {
            
            //cur_max = Math.max(array[i], array[i] + cur_max);
            if(array[i] > array[i] + cur_max) {
                cur_max = array[i];
                tempStart = i;
                tempEnd = i;
            } else {
                cur_max = array[i] + cur_max;
                tempEnd = i;
            }
            //max_so_far = Math.max(max_so_far, cur_max);
            if(cur_max > max_so_far) {
                max_so_far = cur_max;
                start = tempStart;
                end = tempEnd;
            } 
        }
        System.out.println("Max sum is : " + max_so_far);
        
        for(int i = start; i <= end; i++)
            System.out.println(array[i] + " ");
    /*
        int length = array.length;
        table = new int[length];
        prev = new int[length];
        
        for(int i = 0; i < length; i++) {
            table[i] = array[i];
            prev[i] = i;
        }
        
        for(int i = 0; i < length - 1; i++) {
            for(int j = i - 1; j >= 0;  j--) {
                if(table[i] < table[i] + table[j]) {
                    table[i] = table[i] + table[j];
                    prev[i] = j;
                }
                else
                    break;
            }
        }
        
        for(int i = 0; i < length - 1; i++) {
                if(table[length - 1] < table[length - 1] + table[i]) {
                    table[length - 1] = table[length - 1] + table[i];
                    prev[length - 1] = i;
                }
                else
                    break;
        }
        
        int max = table[0];
        int end = 0;
        for(int i = 1; i < length; i++) {
            if(max < table[i]) {
                max = table[i];
                end = i;
            }
        }
        
        System.out.println("Sum is " + max);
        
        for(int i = prev[end]; i <= end; i++ )
            System.out.println(array[i] + " ");
    */
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        LargestSumContiguousSubarray obj = new LargestSumContiguousSubarray();
        obj.largestSumSubArray(new int[]{-2, -3, 4, -1, -2, 1, 5, -3});
        obj.largestSumSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }
    
}
