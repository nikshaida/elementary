package com.softserve.elementary.task_01;

/**
 *App
 *
 *Version 1
 *
 *
 *04.10.2018
 *
 *
 * IT Academy SoftServe
 */
public class App {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("You input incorrect data, you have to start program with two digit");
            return;
        }
        try {
            int width = Integer.parseInt(args[0]);
            int height = Integer.parseInt(args[1]);
            if (!isLegalArg(width, height)){
                System.out.println("You can't use digit below zero");
                return;}
            new Desk(width, height).printDesk();

        } catch (NumberFormatException e) {
            System.out.println("You have to use digit in arguments");
        }

    }

    private static boolean isLegalArg(int width, int hight){
        boolean res = true;

        if (width <=0 || hight <=0){
            res = false;
        }
        return res;
    }



}
