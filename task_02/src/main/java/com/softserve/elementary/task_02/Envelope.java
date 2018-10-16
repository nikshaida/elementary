package com.softserve.elementary.task_02;

import java.util.Objects;

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

    public Envelope(double width, double height) {
        this.width = width;
        this.height = height;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Envelope envelope = (Envelope) o;
        return Double.compare(envelope.width, width) == 0 &&
                Double.compare(envelope.height, height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }
}