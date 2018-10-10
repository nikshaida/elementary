package com.softserve.elementary.task_09;

public class PowMethods {
    

    public static  int powSimple(int a , int b){
        int res;
        int square =a*a;
        if (b == 2) return square;
        if (b%2 == 0){
            for (int i =0; i <= b/2; i++){
                square*=a;
            }
            res = square;
        } else {
            for (int i =0; i < (b-1)/2; i++){
                square*=a;
            }
            res=square*a;
        }
        return res;
    }

    public static  int powRec (int a, int b) {

        if (b==0) return 1;
        if (b % 2 == 1) {
            return powRec(a, b - 1) * a;
        } else {

            int c = powRec(a, b / 2);
            return c * c;
        }
    }
}
