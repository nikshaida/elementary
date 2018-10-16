package com.softserve.elementary.task_03;

import java.util.Comparator;
import java.util.Objects;

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
            this.a = a;
            this.b = b;
            this.c = c;
            this.name = name;
            halfPerimeter = getHalfPerimeter();
            area = setArea();

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.a, a) == 0 &&
                Double.compare(triangle.b, b) == 0 &&
                Double.compare(triangle.c, c) == 0 &&
                Double.compare(triangle.area, area) == 0 &&
                Double.compare(triangle.halfPerimeter, halfPerimeter) == 0 &&
                Objects.equals(name, triangle.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, a, b, c, area, halfPerimeter);
    }
}
