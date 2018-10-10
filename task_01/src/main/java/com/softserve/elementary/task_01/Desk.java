package com.softserve.elementary.task_01;

/**
 * Desk
 *
 * Version 1
 *
 *
 * 04.10.2018
 *
 *
 * IT Academy SoftServe
 **/

public class Desk {
    private int height;
    private int width;

    public Desk( int width, int height) {
        this.height = height;
        this.width = width;
    }

    public void printDesk(){
        /*for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                if ((i+j)%2 == 0){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }*/
        System.out.println(makeDesk());

    }

    private String makeDesk() {
        StringBuilder tmpString = new StringBuilder();
        StringBuilder resString = new StringBuilder();
        for (int i = 0; i < width; i++) {
            if (i % 2 == 0) {
                tmpString.append("*");
            } else {
                tmpString.append(" ");
            }
        }
        tmpString.append("\n");
        for (int j = 0; j < height; j++) {
            if (j % 2 == 0) {
                resString.append(tmpString);
            } else {
                resString.append(" " + tmpString);
            }
        }
        return  resString.toString();
    }


    @Override
    public String toString() {
        return "Desk{" +
                "height=" + height +
                ", width=" + width +
                '}';
    }
}