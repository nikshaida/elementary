package com.softserve.elementary.task_01;


import com.softserve.elementary_tasks.consoleHelper.ConsoleHelper;

/**
 * App
 * <p>
 * Version 1
 * <p>
 * <p>
 * 04.10.2018
 * <p>
 * <p>
 * IT Academy SoftServe
 */
public class App {

    private static final String INCORRECT_INPUT = "You input incorrect data, you have to start program with two digit";
    private static final String NOT_DIGIT = "You have to use natural digit in arguments";

    public static void main(String[] args) {
        if (!ArgsValidator.checkLength(args)) {
            try {
                Desk desk;
                int width = ArgsValidator.getInteger(args[0], "width");
                int height = ArgsValidator.getInteger(args[1], "height");
                if (ArgsValidator.isLegalArg(width, height)) {
                    desk = new Desk(width, height);
                    desk.printDeskToConsol();
                }
            } catch (IllegalArgumentException e) {
                ConsoleHelper.writeMessage(e.getMessage());
            }
        } else {
            ConsoleHelper.writeMessage(INCORRECT_INPUT);
        }

    }
}
