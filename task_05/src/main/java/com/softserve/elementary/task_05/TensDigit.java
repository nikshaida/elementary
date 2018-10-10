package com.softserve.elementary.task_05;

import com.softserve.elementary.task_05.interfaces.PrinteredDigits;

public class TensDigit implements PrinteredDigits {
    private StringBuilder stringBuilder;
    private SimpleDigit simpleDigit;
    private long digit;
    private int first;
    private int simple;

    private String[] arrFirst = {"десять", "одинадцать", "двенадцать", "тринатцать", "четырнадцать", "пятьнадцать", "шестнадцать",
            "семнадцать", "восемнадцать", "девятнадцать"};

    private String[] arrFirstHundred = {" ", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестдесят", "семдесят",
            "восемдесят", "девяносто"};


    public TensDigit(long digit) {
        this.digit = digit;
        first = (int) (digit / 10);
        simple = (int) (digit % 10);
    }


    @Override
    public String getResult(){
       if (stringBuilder == null){
           stringBuilder = new StringBuilder();
       }


        if (first == 0){
            String fs = new SimpleDigit(simple).getResult();
            return  stringBuilder.append(fs).toString();
        }

        if (first == 1){
            stringBuilder.append(arrFirst[simple]);
        } else if (simple == 0) {
            stringBuilder.append(arrFirstHundred[first]);
        } else {simpleDigit = new SimpleDigit(simple);
        stringBuilder.append(arrFirstHundred[first] +" ");
        stringBuilder.append(simpleDigit.getResult());
        }
        return stringBuilder.toString();
    }
    @Override
    public String toString() {
        return getResult();
    }

}
