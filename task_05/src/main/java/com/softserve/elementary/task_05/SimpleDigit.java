package com.softserve.elementary.task_05;

import com.softserve.elementary.task_05.interfaces.PrinteredDigits;

import java.io.BufferedReader;

public class SimpleDigit implements PrinteredDigits {
    private long simpleDigit;
    private static final String[] firstTen = {"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"};

    public SimpleDigit(long i) {
        simpleDigit = i;
    }

    @Override
    public String getResult (){
       return firstTen[(int) simpleDigit];
   }

    @Override
    public String toString() {
        return getResult();
    }
}
