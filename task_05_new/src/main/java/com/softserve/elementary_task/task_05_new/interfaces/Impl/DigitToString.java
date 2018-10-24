package com.softserve.elementary_task.task_05_new.interfaces.Impl;

import com.softserve.elementary_task.task_05_new.interfaces.PrinteredDigits;

public class DigitToString implements PrinteredDigits {
    private static final int SEPARATE_THOUSANDS = 3;
    private static final int TEN = 10;
    private static final int TWENTY = 20;
    private static final int THOUSAND = 1000;
    private static final int HUNDREDS = 100;
    private static final int MILLION = 1_000_000;
    private static final int BILLION = 1_000_000_000;
    private String minus = "минус";
    private String startArg;
    private StringBuilder stringBuilder;
    private static String[] forFirstTwoThousands = {"",
            "одна",
            "две"};
    private static String[] frirst20 = {"",
            "один",
            "два",
            "три",
            "четыре",
            "пять",
            "шесть",
            "семь",
            "восемь",
            "девять",
            "десять",
            "одинадцать",
            "двенадцать",
            "тринадцать",
            "четырнадцать",
            "пятнадцать",
            "шестнадцать",
            "семнадцать",
            "восемнадцать",
            "девятнадцать"};

    private static String[] tenss = {"",
            "",
            "двадцать",
            "тридцать",
            "сорок",
            "пятьдесят",
            "шестьдесят",
            "семьдесят",
            "восемьдесят",
            "девяносто"};

    private static String[] hundreds = {"", "сто",
            "двести",
            "триста",
            "четыреста",
            "пятьсот",
            "шестьсот",
            "семьсот",
            "восемьсот",
            "девятьсот"};

    private static String[][] typeOfDigit = {
            {"", "", ""},
            {"тысяча", "тысячи", "тысяч"},
            {"миллион", "миллиона", "миллионов"},
            {"миллиард", "миллиарда", "миллиардов"}
    };


    public DigitToString(String startArg) {
        this.startArg = startArg;
        this.stringBuilder = new StringBuilder();
    }

    @Override
    public String getResult()  {
        return getStringFromDigit(getDigitFromStartArg(), getTypeOfDigit());

    }

    private int getTypeOfDigit() {
        int res;
        if (startArg.startsWith("-")) {
            stringBuilder.append(minus).append(" ");
             res = (int) Math.ceil(((double)startArg.length()-1) / SEPARATE_THOUSANDS) ;

        } else {
            res = (int) Math.ceil((double) startArg.length() / SEPARATE_THOUSANDS);
        }
        return res;
    }


    private long getDigitFromStartArg() {
        return Math.abs(Long.parseLong(startArg));
    }

    private String getStringFromDigit(long digit, int type) {
        if (type == 1) {
            buildHundreds(digit, 1);
        } else {
            if (type == 4) {
                int billion = (int) (digit / BILLION);
                buildHundreds(billion, type);
                getAddToDigit(billion, type);
                getStringFromDigit(digit % BILLION, type - 1);
            } else if (type == 3) {
                int million = (int) (digit / MILLION);
                buildHundreds(million, type);
                getAddToDigit(million, type);
                getStringFromDigit(digit % MILLION, type - 1);
            } else if (type == 2) {
                int thous = (int) digit / THOUSAND;
                buildHundreds(thous, type);
                getAddToDigit(thous, type);
                getStringFromDigit(digit % THOUSAND, 1);
            }
        }
        return stringBuilder.toString();
    }


    private void getAddToDigit(int digit, int type) {
        if (digit != 0) {
            if (digit > TEN && digit <= TWENTY || digit > HUNDREDS &&
                    digit % HUNDREDS > TEN && digit % HUNDREDS < TWENTY) {
                stringBuilder.append(typeOfDigit[type - 1][2]).append(" ");
            } else if (digit % TEN == 1 || digit == 1) {
                stringBuilder.append(typeOfDigit[type - 1][0]).append(" ");
            } else if (digit % TEN >= 2 && digit % 10 <= 4) {
                stringBuilder.append(typeOfDigit[type - 1][1]).append(" ");
            } else {
                stringBuilder.append(typeOfDigit[type - 1][2]).append(" ");
            }
        }

    }

    private void buildHundreds(long digit, int type) {
        long hund = digit / HUNDREDS;
        long tens = digit % HUNDREDS;
        long last = digit % TEN;
        if (type == 2) {
            if (digit > 0 && digit < 3) {
                stringBuilder.append(forFirstTwoThousands[(int) digit]);
            } else if (digit > 2 && digit < 20) {
                stringBuilder.append(frirst20[(int) digit]).append(" ");
            } else if (digit > HUNDREDS && digit % HUNDREDS > TEN && digit % HUNDREDS < 20) {
                stringBuilder.append(hundreds[(int) hund]).append(" ");
                stringBuilder.append(frirst20[(int) tens]).append(" ");

            } else if (last == 1 || last == 2) {
                stringBuilder.append(hundreds[(int) hund]).append(" ");
                stringBuilder.append(tenss[(int) (tens / TEN)]).append(" ");
                stringBuilder.append(forFirstTwoThousands[(int) last]).append(" ");
            } else {
                stringBuilder.append(hundreds[(int) hund]).append(" ");
                stringBuilder.append(tenss[(int) (tens / TEN)]).append(" ");
                stringBuilder.append(frirst20[(int) last]).append(" ");
            }
        } else {
            if (hund != 0) {
                stringBuilder.append(hundreds[(int) hund]).append(" ");
            }
            if (tens != 0 && tens > 1 && tens < TWENTY) {
                stringBuilder.append(frirst20[(int) tens]).append(" ");
            } else if (tens != 0 && tens >= TWENTY) {
                stringBuilder.append(tenss[(int) (tens / TEN)]).append(" ");
                stringBuilder.append(frirst20[(int) last]).append(" ");
            } else stringBuilder.append(frirst20[(int) last]).append(" ");
        }
    }
}
