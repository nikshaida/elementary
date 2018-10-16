package com.softserve.elementary.task_04;

public class ArgsValidator {

    static boolean checkLenght(String [] args){


        return !(args.length >=2 && args.length <=3);
    }
}
