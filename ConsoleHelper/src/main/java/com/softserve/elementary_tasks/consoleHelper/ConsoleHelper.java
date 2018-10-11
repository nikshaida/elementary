package com.softserve.elementary_tasks.consoleHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class ConsoleHelper
{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String readString() {
        String res = null;
        while (true) {
            try {
                res = reader.readLine();
                return res;

            } catch (IOException e) {
                writeMessage("Something went wrong");
            }
        }
    }


    public static void writeMessage(String message) {
        System.out.println(message);
    }

}
