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


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String action;
        Envelope envelope1;
        Envelope envelope2;
        while (true) {

            try {
                envelope1 = makeEnvelope();
                envelope2 = makeEnvelope();
                System.out.println(compareEnvelope(envelope1, envelope2));
                System.out.println("If you want continue work print 'y' or 'yes'!");
                action = bufferedReader.readLine();
                if (!action.equalsIgnoreCase("y") && !action.equalsIgnoreCase("yes")) {
                    System.out.println("Bye!!");
                    return;
                }
            } catch (NumberFormatException e ){
                System.out.println("You have to use just digit");
                return;
            } catch (IllegalArgumentException e) {
                System.out.println("your height or with can't be below zero");
                return;
            }
        }
    }


    public static String compareEnvelope(Envelope a, Envelope b) {
        double firstWidth = a.getWidth();
        double firstHeight = a.getHeight();
        double secondWidth = b.getWidth();
        double secondHeight = b.getHeight();
        if (firstWidth >= secondWidth && firstHeight >= secondHeight || firstWidth >= secondHeight && firstHeight >= secondWidth ||
                firstWidth <= secondWidth && firstHeight <= secondHeight || firstWidth <= secondHeight && firstHeight <= secondWidth) {
            return "You can put smaller envelope in the bigger";
        } else {
            return "no";
        }
    }

    public static Envelope makeEnvelope() throws IOException, NumberFormatException {
            double width;
            double height;
            System.out.println("Please input width:");
            width = Double.parseDouble(bufferedReader.readLine());
            System.out.println("Please input height:");
            height = Double.parseDouble(bufferedReader.readLine());
            if (width <= 0 || height <= 0) throw new IllegalArgumentException();
            return new Envelope(width, height);


    }


}

