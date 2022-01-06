package com.company;

import java.util.*;

class calculator
{
    public static void main(String a[])
    {
        int number1=0;
        int number2=0;
        int exit;
        char option = 0;
        do
        {
            Scanner input = new Scanner(System.in);

            if(option!=5){
                System.out.println("Enter the first number");
                number1=input.nextInt();

                System.out.println("Choose Operator");
                System.out.println("+, -, *, /,%,5.Exit");
                 option = input.next().charAt(0);

                System.out.println("Enter the second number");
                number2=input.nextInt();

            }

            else
                break;
            switch(option)
            {
                case '+':System.out.println(" "+number1+" + "+number2+" = "+(number1+number2));
                    break;
                case '-':System.out.println(" "+number1+" - "+number2+" = "+(number1-number2));
                    break;
                case '*':System.out.println(" "+number1+" * "+number2+" = "+(number1*number2));
                break;
                case '/':System.out.println(" "+number1+" / "+number2+" = "+(number1/number2));
                    break;
                case '%':System.out.println(" "+number1+" Mod "+number2+" = "+(number1%number2));
                    break;
                case 4: if(number2==0)
                    System.out.println("Error!!! In Division denominator cannot be 0!");
                else{
                    System.out.println("In division of "+number1+" by "+number2+" quotient is "+(number1/number2)+" and remainder is "+(number1%number2));}
                    break;
                case 5: break;
                default: System.out.println("You have entered wrong operator");
            }
            System.out.println("Do you want to continue?1.No 2.Yes");
            exit=input.nextInt();
        }while(exit==1);
    }
}