package com.softserve.elementary.task_02;

public class ArgsValidator {
    static boolean checkLengh(String [] arg){
        boolean res = false;

        if (arg.length != 2) res = true;
        return res;
    }

    static boolean isLegalArg(double width, double hight){
        boolean res = true;

        if (width <=0 || hight <=0){
            res = false;
        }
        return res;
    }
}
