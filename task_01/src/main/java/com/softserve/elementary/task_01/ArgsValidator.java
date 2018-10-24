package com.softserve.elementary.task_01;

import com.softserve.elementary_tasks.consoleHelper.ConsoleHelper;

class ArgsValidator {
     private static final int LENGTH_ARG = 2;
    static boolean checkLength(String [] arg){
        return arg.length != LENGTH_ARG;
    }
    static boolean isLegalArg(int width, int height){
        return !(width <=0 || height <0);
    }

    static int getInteger(String s, String arg){
        int res = 0;
        try {
            res =  Integer.parseInt(s);
        } catch (NumberFormatException e){
            ConsoleHelper.writeMessage("Your "+ arg + " can be only digit");
        }
        if (res <= 0) throw new IllegalArgumentException("Your " + arg + " can't be zero or below zero");
        return res;
    }

}
