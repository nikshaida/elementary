package com.softserve.elementary.task_07;

import com.softserve.elementary_tasks.consoleHelper.ConsoleHelper;

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
        if (!ArgumentChecker.checkLenght(args)) {
            ConsoleHelper.writeMessage("You have to start program just with one argument");
        }
            int digit =1;
        try {
            digit = getArgument(args[0]);
        } catch (NumberFormatException e ){

        }
        if (digit <=1){
            ConsoleHelper.writeMessage("digit have to be more than zero");
        } else {
            ConsoleHelper.writeMessage(getStringResult(getMax(digit)));
        }

    }


    public static int getArgument(String arg) {
        int res = 1;
        try {
              res = Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            ConsoleHelper.writeMessage("You can use just digit");
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



