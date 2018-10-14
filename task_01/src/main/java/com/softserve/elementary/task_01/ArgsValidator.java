package com.softserve.elementary.task_01;

 class ArgsValidator {
     private static final int LENGTH_ARG = 2;

    static boolean checkLength(String [] arg){
        return arg.length != LENGTH_ARG;
    }
    static boolean isLegalArg(int width, int height){
        return !(width <=0 || height <=0);
    }
}
