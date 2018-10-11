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
    private final String BLACK = "*";
    private final String WHITE = " ";
    private int height;
    private int width;

    public Desk(int width, int height) {
        this.height = height;
        this.width = width;
    }

    public void printDesk() {
        ConsoleHelper.writeMessage(makeDesk());

    }

    private String makeDesk() {
        StringBuilder tmpString = new StringBuilder();
        StringBuilder resString = new StringBuilder();
        for (int i = 0; i < width; i++) {
            if (i % 2 == 0) {
                tmpString.append(BLACK);
            } else {
                tmpString.append(WHITE);
            }
        }
        tmpString.append("\n");
        for (int j = 0; j < height; j++) {
            if (j % 2 == 0) {
                resString.append(tmpString);
            } else {
                resString.append(WHITE + tmpString);
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
}