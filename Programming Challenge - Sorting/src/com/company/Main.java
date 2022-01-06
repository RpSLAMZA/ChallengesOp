package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here



        int[] my_array = {25, 14, 56, 15, 36, 56, 88, 18, 29, 49,10,30,50,90,604,2,44,66,3,12,23,34,45,54,32,11,9,33,66,22,1,5,2,7,3,2,11,55,33,56,44,3,2,33,6,9,7,5,4};
        // Insert an element in 3rd position of the array (index->2, value->5)

        int Index_position = 20;
        int newValue    = 60;
        int Index_pos = 6;
        int newVal    = 6;

        System.out.println("Original Array : "+Arrays.toString(my_array));

        for(int i=my_array.length-1; i > Index_position; i--){
            my_array[i] = my_array[i-1];
            Arrays.sort(new int[][]{my_array},Collections.reverseOrder());

        }
        my_array[Index_position] = newValue;
        my_array[Index_pos] = newVal;


        System.out.println("New Array: "+Arrays.toString(my_array));

        }
    }

