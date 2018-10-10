package com.softserve.elementary.task_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
public class App {
    private List<Triangle> triangles = new ArrayList<>();

    public void addTriangl(Triangle triangle) {
        triangles.add(triangle);
    }

    public void printTriangls() {

        Collections.sort(triangles, (o1, o2) -> {
            if (o1.getArea() > o2.getArea()) {
                return 1;
            } else if (o1.getArea() < o2.getArea()) {
                return -1;
            } else {
                return 0;
            }
        });
        System.out.println("============= Triangles list: ===============");
        triangles.forEach(triangle -> System.out.println(triangles) );


    }


    public double[] getSides(String[] arr) {
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


    public static void main(String[] args) throws IOException {
        App app = new App();
        String full;
        String name;
        String action;
        double aSide;
        double bSide;
        double cSide;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Triangle triangle;

        while (true) {
            System.out.println("Print name of your rectangle and sides of your rectangle separate by coma ");
            full = bufferedReader.readLine();
            String[] arg = full.split(",");
            if (arg.length != 4) {
                System.out.println("You have to put just name and sides of your rectangle");
                continue;
            }
            name = arg[0].replaceAll("\\s", "");

            try {
                double[] sides = app.getSides(arg);
                aSide = sides[0];
                bSide = sides[1];
                cSide = sides[2];
                triangle = new Triangle(name, aSide, bSide, cSide);
                app.addTriangl(triangle);
                System.out.println("If you want add more triangle print 'y' or 'yes' ");
                action = bufferedReader.readLine();
                if (action.toLowerCase().equals("y") || action.toLowerCase().equals("yes")) {
                    continue;
                } else {
                    System.out.println("Bye!");
                }
                app.printTriangls();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }

    }
}
