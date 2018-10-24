package com.softserve.elementary.task_05;

import com.softserve.elementary.task_05.interfaces.PrinteredDigits;
import com.softserve.elementary_tasks.consoleHelper.ConsoleHelper;


public class DigitToString {
    private String digit;

    public DigitToString(String digit) {
        this.digit = digit;
    }

    public void printResult() {
        ConsoleHelper.writeMessage(getDigitString());
    }

    public String getDigitString() {
        StringBuilder res = new StringBuilder();
        long myDigit;
        PrinteredDigits printeredDigits = null;
        try {
            myDigit = getDigitFromString();
        } catch (NumberFormatException e) {
            res.append("You make mistake in your argument, you have to use natural digit");
            return res.toString();
        }

        int typeDigit = digit.length();
        if (myDigit < 0) {
            myDigit *= -1;
            typeDigit -= 1;
            res.append("минус ");
        }
        if (typeDigit == 1) {
            printeredDigits = new SimpleDigit(myDigit);
        } else if (typeDigit == 2) {
            printeredDigits = new TensDigit(myDigit);
        } else if (typeDigit == 3) {
            printeredDigits = new HundredDigit(myDigit);
        } else if (typeDigit > 3 && typeDigit <= 6) {
            printeredDigits = new ThousandDigit(myDigit);
        } else if (typeDigit > 6 && typeDigit <= 9) {
            printeredDigits = new MillionDigit(myDigit);
        } else if (typeDigit > 9 && typeDigit <= 12) {
            printeredDigits = new BillionDigit(myDigit);
        }

        res.append(printeredDigits.getResult());
        return res.toString();

    }

    private long getDigitFromString() {
        return Long.parseLong(digit);
    }
}
