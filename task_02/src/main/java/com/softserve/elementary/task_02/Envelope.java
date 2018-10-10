package com.softserve.elementary.task_02;

/**
 * Envelope
 *
 * Version 1
 *
 *
 * 04.10.2018
 *
 *
 * IT Academy SoftServe
 **/


public class Envelope {
    private double width;
    private double height;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Envelope(double width, double height) {
            this.width = width;
            this.height = height;
    }

}