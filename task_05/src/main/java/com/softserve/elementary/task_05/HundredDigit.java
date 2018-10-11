package com.softserve.elementary.task_05;

import com.softserve.elementary.task_05.interfaces.PrinteredDigits;

public class HundredDigit implements PrinteredDigits {
    private StringBuilder stringBuilder;
    private TensDigit tensDigit;
    private String[] arrHundred = {"ноль", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятсот"};
    private long digit;

    public HundredDigit(long digit) {
        this.digit = digit;
    }

    @Override
    public String getResult(){
        if (stringBuilder == null){
        stringBuilder = new StringBuilder();}
        int first = (int) (digit / 100);
        int other = (int) (digit % 100);
        if (first == 0){
            tensDigit = new TensDigit(other);
           return stringBuilder.append(tensDigit.getResult()).toString();
        }

        if (other == 0){
            stringBuilder.append(arrHundred[first]);
        } else {
            stringBuilder.append(arrHundred[first]+ " ");
            tensDigit = new TensDigit(other);
            stringBuilder.append(tensDigit.getResult());
        }
        return stringBuilder.toString();
    }
    @Override
    public String toString() {
        return getResult();
    }
    
}
