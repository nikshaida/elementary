package com.softserve.elementary.task_07;

public class ArgumentChecker {
    static boolean checkLenght(String [] arg){
        boolean res = true;
        if (arg.length != 1){
            res = false;
        }
        return res;
    }

}
