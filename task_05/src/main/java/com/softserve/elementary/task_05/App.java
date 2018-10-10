package com.softserve.elementary.task_05;

import com.softserve.elementary.task_05.interfaces.PrinteredDigits;

import java.math.BigInteger;

/**
 *
 *
 */
public class App 
{
    public static void main( String[] args ) {
       if (args.length !=1){
            System.out.println("You have to use just one argument");
            return;
        }
        DigitToString digitToString = new DigitToString(args[0]);
        digitToString.printResult();
    }

}

