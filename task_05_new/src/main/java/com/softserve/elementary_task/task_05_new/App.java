package com.softserve.elementary_task.task_05_new;

import com.softserve.elementary_task.task_05_new.interfaces.Impl.DigitToString;
import com.softserve.elementary_tasks.consoleHelper.ConsoleHelper;

/**
 * Hello world!
 *
 */
public class App 
{

    private static final String NUMBER_ERROR = "You can use just natural digit";
    private static final String PROBLEM_WITH_ARG = "You can't start program without argument";

    public static void main(String[] args)
    {
        if (args.length == 1) {
            try {
                DigitToString digitToString = new DigitToString(Long.parseLong(args[0]));
                ConsoleHelper.writeMessage(digitToString.getResult());
            } catch (NumberFormatException e) {
                ConsoleHelper.writeMessage(NUMBER_ERROR);
            }
        } else {
            ConsoleHelper.writeMessage(PROBLEM_WITH_ARG);
        }
    }
}
