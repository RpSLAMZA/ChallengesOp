package com.company;

public class Main {

    public static void main(String[] args) {
        // Set it to the number of elements you want in the Fibonacci Series
        int max = 15;
        int previousNum = 0;
        int secondNumber = 1;

        for (int i = 1; i <= max; ++i)
        {System.out.println(previousNum+" ");

            int sum = previousNum + secondNumber;
            previousNum = secondNumber;
            secondNumber = sum;

        }
    }
}