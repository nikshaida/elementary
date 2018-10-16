package com.softserve.elementary.task_06;
/**
 * LuckyTickets
 *
 * Version 1
 *
 *
 * 06.10.2018
 *
 *
 * IT Academy SoftServe
 **/

import java.util.ArrayList;
import java.util.List;

public class LuckyTickets {
    private static final int DEFAULT_TYPE = 6;
    private static final int MAX_DIGIT_IN_ROW = 9;
    private String algorithm;
    private int type;


    public LuckyTickets() {
        this.type = DEFAULT_TYPE;
    }

    public LuckyTickets(String algorithm) {
        this.algorithm = algorithm;
        this.type = DEFAULT_TYPE;
    }

    public LuckyTickets(String algorithm, int type) {
        this.algorithm = algorithm;
        this.type = type;
    }


    public int getMoscowUseRecAndCombi(){
        int res = 0;
        for (int i = 1; i < countMaxSum(); i++ ){
            int variantForTicket = variantForTicket(type/2, i);
            res+=variantForTicket*variantForTicket;
        }
        return res;
    }

    private int variantForTicket(int countHalf, int ticketNum) {
        if (countHalf == 1) {
            return (ticketNum <= MAX_DIGIT_IN_ROW ? 1 : 0);
        } else {
            int count = 0;
            for (int i = 0; i <= (ticketNum < MAX_DIGIT_IN_ROW ? ticketNum : MAX_DIGIT_IN_ROW); ++i) {
                count += variantForTicket(countHalf - 1, ticketNum - i);
            }
            return count;
        }
    }

    public int getPeter() {
        int count = 0;
        for (int i = 10; i < countVariant(); i++) {
            if (isLuckyPeter(digitToList(i))) {
                count++;
            }
        }
        return count;
    }

    public int getDnepr() {
        int count = 0;
        for (int i = 10; i < countVariant(); i++) {
            if (isLuckyDnepr(digitToList(i))) {
                count++;
            }
        }
        return count;
    }

    private int countVariant(int num) {
        int res = 1;
        for (int i = 0; i < num/2; i++) {
            res *= 10;
        }
        return res;
    }

    private int countVariant() {
        int res = 1;
        for (int i = 0; i < type; i++) {
            res *= 10;
        }
        return res;
    }

    private int countMaxSum(){
        return (type/2)*MAX_DIGIT_IN_ROW;
    }



    private boolean isLuckyMoscow(List<Integer> list) {
        boolean res = false;
        int resToFirstPart = 0;
        int resToSecondPart = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() / 2) {
                resToFirstPart += list.get(i);
            } else {
                resToSecondPart += list.get(i);
            }
        }
        if (resToFirstPart == resToSecondPart) {
            res = true;
        }
        return res;
    }

    private boolean isLuckyPeter(List<Integer> list) {
        boolean res = false;
        int resToFirstPart = 0;
        int resToSecondPart = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) {
                resToFirstPart += list.get(i);
            } else {
                resToSecondPart += list.get(i);
            }
        }
        if (resToFirstPart == resToSecondPart) {
            res = true;
        }
        return res;
    }


    private boolean isLuckyDnepr(List<Integer> list) {
        boolean res = false;
        int resToFirstPart = 0;
        int resToSecondPart = 0;
        for (int i = 0; i < list.size(); i++) {
            int tmp = list.get(i);
            if (tmp % 2 == 0) {
                resToFirstPart += list.get(i);
            } else {
                resToSecondPart += list.get(i);
            }
        }
        if (resToFirstPart == resToSecondPart) {
            res = true;
        }
        return res;
    }

    private List<Integer> digitToList(int digit) {
        List<Integer> list = new ArrayList<>();
        while (digit / 10 > 0) {
            list.add(digit % 10);
            digit /= 10;
            if (digit < 10) list.add(digit);
        }
        return list;
    }

    private int getSumOnePart(int num){
        int res = 0;
        while (num >0){
            res+=num%10;
            num/=10;
        }
        return res;
    }

    public int getResult(){
        if (algorithm.equalsIgnoreCase("Moscow")){
            return getMoscowUseRecAndCombi();
        }  else if (algorithm.equalsIgnoreCase("Dnepr")){
            return getDnepr();
        } else {
            return getPeter();
        }
    }
}

