package com.softserve.elementary.task_04;

import com.softserve.elementary.task_04.interfaces.StringSearchable;
import com.softserve.elementary_tasks.consoleHelper.ConsoleHelper;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * App
 * <p>
 * Version 1
 * <p>
 * <p>
 * 06.10.2018
 * <p>
 * <p>
 * IT Academy SoftServe
 **/
public class App {
    private static final String INSTRUCTIONS = "Your have mistake in your argument, program will work just with 2 or 3 argument + \n" +
            "start program with 2 arguments to count the string in the file  <path to File> <String for counting>\n" +
            "start program with 3 arguments to replace string in file  <path to File> <String for counting> <replacementString>  ";
    private static final String COUNTING = "The amount of line including: ";
    private static final String FILE_PROBLEM = "You have some problem with your file";
    private static final String IO_PROBLEM = "Some problem";


    public static void main(String[] args) {
        StringSearchable operation;

        if (ArgsValidator.checkLenght(args)) {
            ConsoleHelper.writeMessage(INSTRUCTIONS);
        } else {
            operation = new FileUtilImplStringSearchable();
            if (args.length == 2) {

                try {
                    ConsoleHelper.writeMessage(COUNTING + operation.countString(args[0], args[1]));
                } catch (FileNotFoundException e) {
                    ConsoleHelper.writeMessage(FILE_PROBLEM);
                } catch (IOException e) {
                    ConsoleHelper.writeMessage(IO_PROBLEM);
                }
            } else {

                try {
                    operation.replaceString(args[0], args[1], args[2]);
                } catch (FileNotFoundException e) {
                    ConsoleHelper.writeMessage(FILE_PROBLEM);
                } catch (IOException e) {
                    ConsoleHelper.writeMessage(IO_PROBLEM);
                }
            }

        }
    }
}
