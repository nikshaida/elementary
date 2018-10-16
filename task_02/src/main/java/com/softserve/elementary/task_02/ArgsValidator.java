package com.softserve.elementary.task_02;

public class ArgsValidator {
        static boolean isLegalArg(double width, double hight){
         return !(width <=0 || hight <=0);
    }
}
