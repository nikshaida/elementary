package com.softserve.elementary.task_02;

/**
 * App
 *
 * Version 1
 *
 *
 * 04.10.2018
 *
 *
 * IT Academy SoftServe
 **/


import com.softserve.elementary_tasks.consoleHelper.ConsoleHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    private static final String ASK_CONT = "If you want continue work print 'y' or 'yes'!";
    private static final String YES = "yes";
    private static final String YYY = "y";
    private static final String BYE_MESS = "Bye!!";
    private static final String NUMBER_EXCEPTION = "You have to use just digit";
    private static final String NUMBER_BELOW_ZERO = "your height or with can't be below zero";
    private static final String POSITIVE = "You can put smaller to the bigger";
    private static final String NEGATIVE = "You can't put one Envelope to another";
    private static final String WIDTH = "Please input width:";
    private static final String HEIGHT = "Please input height:";

    public static void main(String[] args) throws IOException {
        String action;
        Envelope envelope1;
        Envelope envelope2;
        double width;
        double height;
        boolean work = true;
        while (work) {
            try {
                ConsoleHelper.writeMessage(WIDTH);
                width = readParam();
                ConsoleHelper.writeMessage(HEIGHT);
                height = readParam();
                envelope1 = makeEnvelope(width, height);
                ConsoleHelper.writeMessage(WIDTH);
                width = readParam();
                ConsoleHelper.writeMessage(HEIGHT);
                height = readParam();
                envelope2 = makeEnvelope(width, height);
                if (isFit(envelope1, envelope2)){
                  ConsoleHelper.writeMessage(POSITIVE);
                } else {
                    ConsoleHelper.writeMessage(NEGATIVE);
                }
                ConsoleHelper.writeMessage(ASK_CONT);
                action = ConsoleHelper.readString();
                if (!action.equalsIgnoreCase(YYY) && !action.equalsIgnoreCase(YES)) {
                    ConsoleHelper.writeMessage(BYE_MESS);
                    work = false;
                }
            } catch (NumberFormatException e ){
                ConsoleHelper.writeMessage(NUMBER_EXCEPTION);
                work = false;
            } catch (IllegalArgumentException e) {
                ConsoleHelper.writeMessage(NUMBER_BELOW_ZERO);
                work = false;
            }
        }
    }


    public static boolean isFit(Envelope a, Envelope b) {
        double firstWidth = a.getWidth();
        double firstHeight = a.getHeight();
        double secondWidth = b.getWidth();
        double secondHeight = b.getHeight();
        return  (firstWidth >= secondWidth && firstHeight >= secondHeight || firstWidth >= secondHeight && firstHeight >= secondWidth ||
                firstWidth <= secondWidth && firstHeight <= secondHeight || firstWidth <= secondHeight && firstHeight <= secondWidth);
    }

    public static Envelope makeEnvelope(double width, double height)  {
        if (!ArgsValidator.isLegalArg(width, height)) {throw new IllegalArgumentException();}
        return new Envelope(width, height);
    }


    public static double readParam() throws NumberFormatException {
        return Double.parseDouble(ConsoleHelper.readString());
    }


}

