package com.softserve.elementary.task_05;

import com.softserve.elementary.task_05.interfaces.PrinteredDigits;

public class BillionDigit implements PrinteredDigits {
   private MillionDigit millionDigit;
   private HundredDigit hundredDigit;
   private long digit;
   private int digitBillion;
   private StringBuilder stringBuilder;
   private int millions;

    public BillionDigit(long digit) {
        this.digit = digit;
        digitBillion = (int) (digit / 1000000000);
        millions = (int) (digit % 1000000000);
        //digitBillion = Integer.valueOf(digit.substring(0, digit.length()-9));
    }

    @Override
    public String getResult() {
        stringBuilder = new StringBuilder();
        if (millions == 0) {
            getBillionDigit();
            getBillionWord();
        } else {
            getBillionDigit();
            getBillionWord();
            millionDigit = new MillionDigit(digit % 1000000000);
            stringBuilder.append(millionDigit.getResult());
        }

        return stringBuilder.toString();
    }

    private void getBillionDigit (){
        hundredDigit = new HundredDigit(digitBillion);
        stringBuilder.append(hundredDigit.getResult());
    }

    private void getBillionWord(){
        if (digitBillion > 10 && digitBillion < 20 || digitBillion > 100 && digitBillion % 100 >10 && digitBillion % 100 <20){
            stringBuilder.append(" миллиардов ");
        } else if (digitBillion %10 == 1 || digitBillion ==1 ) {
            stringBuilder.append( " миллиард ");
        } else if ( digitBillion %10 >=2 && digitBillion %10 <= 4){
            stringBuilder.append(" миллиарда ");
        } else {
            stringBuilder.append(" миллиардов ");
        }
    }
}
