package com.softserve.elementary.task_06;

public class Ticket {
    private static final int DEFAULT_TYPE = 6;

    private int type;
    private int number;

    public Ticket() {
    }

    public Ticket(int number) {
        this.number = number;
        this.type = DEFAULT_TYPE;
    }

    public Ticket(int type, int number) {
        this.type = type;
        this.number = number;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
