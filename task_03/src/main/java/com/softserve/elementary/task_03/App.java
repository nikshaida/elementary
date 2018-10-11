package com.softserve.elementary.task_03;

import com.softserve.elementary_tasks.consoleHelper.ConsoleHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * App
 * <p>
 * Version 1
 * <p>
 * <p>
 * 04.10.2018
 * <p>
 * <p>
 * IT Academy SoftServe
 **/
public class App {

    public static final String START_MESS = "Print name of your rectangle and sides of your rectangle separate by coma ";
    public static final String COUNT_ARGS = "You have to put just name and sides of your rectangle";
    public static final String CONT_OR_NOT = "If you want add more triangle print 'y' or 'yes' ";

    private static List<Triangle> triangles = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        String full;

        String action;

        Triangle triangle;

        boolean workTime = true;

        while (workTime) {
            ConsoleHelper.writeMessage(START_MESS);
            full = ConsoleHelper.readString();
            String[] arg = full.split(",");
            if (!ArgsValidator.checkLenght(arg)) {
                ConsoleHelper.writeMessage(COUNT_ARGS);
                continue;
            }

            try {
                triangle = makeTriangle(arg);
                addTriangl(triangle);
                ConsoleHelper.writeMessage(CONT_OR_NOT);
                action = ConsoleHelper.readString();
                if (action.toLowerCase().equals("y") || action.toLowerCase().equals("yes")) {
                    continue;
                } else {
                    ConsoleHelper.writeMessage("Bye!");
                    workTime = false;
                }

                printTriangls();
            } catch (IllegalArgumentException e) {
                ConsoleHelper.writeMessage(e.getMessage());
                workTime = false;
            }
        }

    }



    public static void addTriangl(Triangle triangle) {
        triangles.add(triangle);
    }

    public static void printTriangls() {

        Collections.sort(triangles, (o1, o2) -> {
            if (o1.getArea() > o2.getArea()) {
                return 1;
            } else if (o1.getArea() < o2.getArea()) {
                return -1;
            } else {
                return 0;
            }
        });
        ConsoleHelper.writeMessage("============= Triangles list: ===============");
        triangles.forEach(triangle -> ConsoleHelper.writeMessage(triangle.toString()));

    }


    public static double[] getSides(String[] arr) throws IllegalArgumentException {
        double[] res = new double[3];
        String temp;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i].toLowerCase().trim();
            Pattern pattern = Pattern.compile("(\\d+|\\d+\\.?\\d+)");
            Matcher matcher;
            matcher = pattern.matcher(temp);
            if (!matcher.matches()) {
                throw new IllegalArgumentException("You make mistake in one of your arguments");
            }
            res[i - 1] = Double.valueOf(temp);
        }
        return res;
    }

    public static Triangle makeTriangle(String[] args) throws IllegalArgumentException {
        Triangle triangle;
        String name;
        double aSide;
        double bSide;
        double cSide;
        name = args[0].replaceAll("\\s", "");
        double[] sides = getSides(args);
        aSide = sides[0];
        bSide = sides[1];
        cSide = sides[2];
        triangle = new Triangle(name, aSide, bSide, cSide);
        return triangle;
    }


}
