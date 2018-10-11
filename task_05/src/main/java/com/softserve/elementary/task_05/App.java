package com.softserve.elementary.task_05;


import com.softserve.elementary_tasks.consoleHelper.ConsoleHelper;

/**
 *
 *
 */
public class App {
    public static void main(String[] args) {
        if (args.length != 1) {
            ConsoleHelper.writeMessage("You have to use just one argument");
        } else {
            DigitToString digitToString = new DigitToString(args[0]);
            digitToString.printResult();
        }
    }

}

