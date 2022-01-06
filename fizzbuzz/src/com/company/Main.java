package com.company;

public class Main {

	// write your code here

            public static void main(String args[]){

                for (int num = 1; num  <= 100; num ++) {
                    if (num  % 3 == 0 && num  % 5 == 0) {
                        System.out.println("Fizz Buzz");
                    } else if (num  % 3 == 0) {
                        System.out.println("Fizz");
                    } else if (num  % 5 == 0) {
                        System.out.println("Buzz");
                    } else {
                        System.out.println(num );
                    }
                }
            }
}


