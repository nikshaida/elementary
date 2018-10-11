package com.softserve.elementary.task_03;

public class ArgsValidator {


     static boolean checkLenght(String [] args){
        boolean res = false;
        if (args.length ==4) res = true;
         return res;
     }


}
