package com.softserve.elementary.task_07;

/**
 * App
 *
 * Version 1
 *
 *
 * 07.10.2018
 *
 *
 * IT Academy SoftServe
 **/
public class App {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("You have to start program just with one argument");
            return;
        }

        int digit = checkArg(args[0]);
        System.out.println(getStringResult(getMax(digit)));


    }


    public static int checkArg(String arg) {
        int res = 1;
        try {
            res = Integer.parseInt(arg);
            if (res <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.println("You can use just digit, digit have to be more than zero");
            System.exit(0);
        }

        return res;

    }

    public static int getMax(int digit) {
        return (int) Math.sqrt(digit);
    }

    public static String getStringResult(int max) {
        StringBuilder res = new StringBuilder();
        for (int i = 1; i < max; i++) {
            res.append(i + ", ");
        }
        res.append(max);
        return res.toString();
    }

}



