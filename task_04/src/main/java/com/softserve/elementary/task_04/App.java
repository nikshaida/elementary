package com.softserve.elementary.task_04;

import com.softserve.elementary.task_04.interfaces.StringSearchable;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * App
 *
 * Version 1
 *
 *
 * 06.10.2018
 *
 *
 * IT Academy SoftServe
 **/
public class App {
    public static void main(String[] args) {
        StringSearchable operation;

        if (args.length < 2 || args.length > 3) {
            System.out.println("Your have mistake in your argument, program will work just with 2 or 3 argument + \n" +
                    "start program with 2 arguments to count the string in the file  <path to File> <String for counting>\n" +
                    "start program with 3 arguments to replace string in file  <path to File> <String for counting> <replacementString>  ");
        return;
        }
        if (args.length == 2) {

            operation = new FileUtilImplStringSearchable();
            try {
                System.out.println("The amount of line including: " + operation.countString(args[0], args[1]));

            } catch (FileNotFoundException e) {
                System.out.println("You have some problem with your file");
            } catch (IOException e) {
                System.out.println("Some problem");
            }

        } else {
                operation = new FileUtilImplStringSearchable();
                try {
                    operation.replaceString(args[0], args[1], args[2]);
                } catch (FileNotFoundException e) {
                    System.out.println("You have some problem with your file");
                } catch (IOException e) {
                    System.out.println("Some problem");
                }
            }

        }
    }
