package com.softserve.elementary.task_08;

import com.softserve.elementary_tasks.consoleHelper.ConsoleHelper;


/**
 *
 *
 */
public class App {
    public static void main(String[] args) {
        if (args.length != 2) {
            ConsoleHelper.writeMessage("You have to specify range");

        } else {

            try {
                int start = Integer.parseInt(args[0]);
                int finish = Integer.parseInt(args[1]);

                if (checkArg(start, finish)) {
                   ConsoleHelper.writeMessage(printRangeOfFib(start, finish));
                } else {
                    ConsoleHelper.writeMessage("You digit must be bigger then zero");
                }

            } catch (NumberFormatException e) {
                ConsoleHelper.writeMessage("you have to use digit");
            }

        }
    }

    public static String printRangeOfFib(int startRange, int endRange) {
        StringBuilder stringBuilder = new StringBuilder();
        long fib;
        if ((endRange - startRange) < startRange || startRange > endRange) {
            return stringBuilder.append("No digit in this range").toString();
        }
        for (int i = 1; i < endRange; i++) {
            fib = fibDigit(i);
            if (fib > endRange) break;
            if ((fib = fibDigit(i)) > startRange) stringBuilder.append(fib + ", ");
        }
        return  stringBuilder.substring(0, stringBuilder.lastIndexOf(", "));

    }

    public static int fibDigit(int n) {
        int first = 0;
        int second = 1;
        for (int i = 1; i < n; i++) {
            second = first + second;
            first = second - first;
        }
        return second;
    }

    public static boolean checkArg(int min, int max) {
        return !(min < 0 || max <= 0);
    }

}
