package com.softserve.elementary.task_01;
import com.softserve.elementary_tasks.consoleHelper.ConsoleHelper;
/**
 * App
 *
 * Version 1
 *
 *
 * 04.10.2018
 *
 *
 * IT Academy SoftServe
 */
public class App {

    private static final String INCORRECT_INPUT = "You input incorrect data, you have to start program with two digit";
    private static final String NOT_DIGIT = "You have to use natural digit in arguments";

    public static void main(String[] args) {
        if (ArgsValidator.checkLength(args)) {
            ConsoleHelper.writeMessage(INCORRECT_INPUT);
        } else {
            Desk desk;
            int width = 0;
            int height = 0;
            try {
                width = Integer.parseInt(args[0]);
                height = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                ConsoleHelper.writeMessage(NOT_DIGIT);
            }
            if (ArgsValidator.isLegalArg(width, height)) {
                desk = new Desk(width, height);
                desk.printDeskToConsol();
            }
        }
    }
}
