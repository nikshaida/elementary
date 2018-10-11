package com.softserve.elementary.task_04;

public class ArgsValidator {

    static boolean checkLenght(String [] args){
        boolean res = false;
        if (args.length >=2 && args.length <=3){
            res = true;
        }
        return res;
    }
}
