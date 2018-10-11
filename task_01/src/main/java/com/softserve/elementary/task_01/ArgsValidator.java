package com.softserve.elementary.task_01;

public class ArgsValidator {
    static boolean checkLengh(String [] arg){
        boolean res = false;

        if (arg.length != 2) res = true;
        return res;
    }

    static boolean isLegalArg(int width, int hight){
        boolean res = true;

        if (width <=0 || hight <=0){
            res = false;
        }
        return res;
    }


}
