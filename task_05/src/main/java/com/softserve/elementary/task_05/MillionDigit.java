package com.softserve.elementary.task_05;

import com.softserve.elementary.task_05.interfaces.PrinteredDigits;

public class MillionDigit implements PrinteredDigits {

    private long digit;
    private int first;
    private int thousand;
    private int last;
    private ThousandDigit thousandDigit;
    private StringBuilder stringBuilder;

    public MillionDigit(long digit) {
        this.digit = digit;
        first = (int) (digit / 1000000);
        last = first % 10;
        thousand = (int) (digit % 1000000);
    }

    @Override
    public String getResult() {

        stringBuilder = new StringBuilder();
        if (first == 0){

            thousandDigit = new ThousandDigit(thousand);
            stringBuilder.append(thousandDigit.getResult());
        } else if (thousand == 0) {
            getMillionDigit();
            getMillionWord();
        } else  {
            getMillionDigit();
            getMillionWord();

            thousandDigit = new ThousandDigit(thousand);
            stringBuilder.append(thousandDigit.getResult());
        }
      return stringBuilder.toString();
    }


    private void getMillionDigit (){
        thousandDigit = new ThousandDigit(first);
        stringBuilder.append(thousandDigit.getResult());
    }

    private void getMillionWord(){
        if (first > 10 && first < 20 || first > 100 && first % 100 >10 && first % 100 <20 ){
            stringBuilder.append(" миллионов ");
        } else if (last == 1 || first == 1) {
            stringBuilder.append( " миллион ");
        } else if ( last >=2 && last <= 4){
            stringBuilder.append(" миллиона ");
        } else {
            stringBuilder.append(" миллионов ");
        }

    }

}
