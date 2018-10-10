package com.softserve.elementary.task_05;

import com.softserve.elementary.task_05.interfaces.PrinteredDigits;

public class ThousandDigit implements PrinteredDigits {
   private StringBuilder stringBuilder;
   private long digit;
   private int first;
   private int hundreds;
   private  int lastDigit;
   private HundredDigit hundredDigit;
   private String[] firstTenThousand = {"", "одна", "две", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять", "десять",  "одинадцать", "двенадцать", "тринатцать", "четырнадцать", "пятьнадцать", "шестнадцать",
            "семнадцать", "восемнадцать", "девятнадцать"};
    public ThousandDigit(long digit) {
        this.digit = digit;
        first = (int) (digit / 1000);
        hundreds = (int) (digit % 1000);
        lastDigit = first % 10;
    }

    @Override
    public String getResult() {
        stringBuilder = new StringBuilder();
        if (first == 0){
            hundredDigit = new HundredDigit(hundreds);
            stringBuilder.append(hundredDigit.getResult());
        } else  if (hundreds == 0) {
            getThousandDigit();
            getThousandWorld();
        } else {
            getThousandDigit();
            getThousandWorld();
            hundredDigit = new HundredDigit(hundreds);
            stringBuilder.append(hundredDigit.getResult());
        }
        return  stringBuilder.toString();
    }


    private void getThousandDigit(){
        if (first > 0 && first < 20){
            stringBuilder.append(firstTenThousand[first]);
        } else if (first > 100 && first % 100 >10 && first % 100 <20){
            hundredDigit = new HundredDigit(first);
            stringBuilder.append(hundredDigit.getResult());
        } else  if (first %10 ==1 || first % 10 ==2) {
            hundredDigit = new HundredDigit(first - first % 10);
            stringBuilder.append(hundredDigit.getResult() + " ");
            stringBuilder.append(firstTenThousand[first % 10]);
        } else {
            hundredDigit = new HundredDigit(first);
            stringBuilder.append(hundredDigit.getResult());
        }

    }

    private String getThousandWorld(){

        if (first > 10 && first < 20){
            stringBuilder.append(" тысячь ");
        } else if (first > 100 && first % 100 >10 && first % 100 <20 ) {
            stringBuilder.append(" тысячь ");
        } else if (lastDigit == 1) {
            stringBuilder.append( " тысяча ");
        } else if ( lastDigit >=2 && lastDigit <= 4){
            stringBuilder.append(" тысячи ");
        } else {
            stringBuilder.append(" тысячь ");
        }
        return stringBuilder.toString();
    }
    @Override
    public String toString() {
        return getResult();
    }

}
