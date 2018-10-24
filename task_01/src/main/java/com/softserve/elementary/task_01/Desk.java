package com.softserve.elementary.task_01;

import com.softserve.elementary_tasks.consoleHelper.ConsoleHelper;

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
    private String black;
    private String white;
    private int height;
    private int width;

    public Desk(int width, int height, String black, String white) {
        this.black = black;
        this.white = white;
        this.height = height;
        this.width = width;
    }

    public Desk(int width, int height) {
        this(width, height, "*", " ");

    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void printDeskToConsol() {
        ConsoleHelper.writeMessage(makeDeskInString());
    }

    String makeDeskInString() {
        StringBuilder tmpString = new StringBuilder();
        StringBuilder resString = new StringBuilder();
        for (int i = 0; i < width; i++) {
            tmpString.append(isBlack(i)  ? black : white);
            if (i == width-1){
                tmpString.append("\n");
            }

        }

        for (int j = 0; j < height; j++) {
            if (j % 2 == 0) {
                resString.append(tmpString);
            } else {
                resString.append(white).append(tmpString);
                resString.replace(resString.lastIndexOf(white), resString.length()-1, "");
            }
        }
        return resString.toString();
    }

    @Override
    public String toString() {
        return "Desk{" +
                "height=" + height +
                ", width=" + width +
                '}';
    }

    private boolean isBlack(int i){
        return i%2 == 0;
    }
}