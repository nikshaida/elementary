package com.softserve.elementary.task_03;

import java.util.Comparator;

/**
 * Triangle
 *
 * Version 1
 *
 * 04.10.2018
 *
 *
 * IT Academy SoftServe
 **/



public class Triangle  {
    private String name;
    private double a;
    private double b;
    private double c;
    private double area;
    private double halfPerimeter;



    public Triangle(String name, double a, double b, double c) {
        if (checkRectangle(a, b, c)) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.name = name;
            halfPerimeter = getHalfPerimeter();
            area = setArea();
        } else {
            throw new IllegalArgumentException("Your triangle can't be created");
        }
    }


    public double getArea(){
        return area;
    }

    @Override
    public String toString() {
        return "[Triangle " + name + "]: " + String.format("%.2f", area) + " cm2";
    }

    private double getHalfPerimeter() {
        return (a + b + c) / 2;
    }



    private double setArea() {
        return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
    }

    private boolean checkRectangle(double a, double b, double c){
        if (a <=0 || b <=0 || c <=0){
            return false;
        }
        if (a < (c+b) && c < (a+b) && b <= (c+a)) {
            return true;
        } else {
            return false;
        }

    }

}
