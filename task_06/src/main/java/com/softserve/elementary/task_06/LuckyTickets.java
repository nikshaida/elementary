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

    private int type;


    public LuckyTickets() {
        this.type = 6;
    }

   /* public LuckyTickets(int type) {
        this.type = type;
    }
*/

    public int getMoscow() {
        int count = 0;
        for (int i = 9; i < countVariant(); i++) {
            if (isLuckyMoscow(digitToList(i))) {
                count++;
            }
        }
        return count;

    }

    public int getMoscowSimple(){
        int count = 0;
        for (int i = 0; i < countVariant(type); i++){
            for (int j = 0; j < countVariant(type); i++){
                if (getSumOnePart(i) == getSumOnePart(j)){
                    count++;
                }
            }
        }
        return count;
    }

    public int getPeter() {
        int count = 0;
        for (int i = 10; i < countVariant(); i++) {
            if (isLuckyDnepr(digitToList(i))) {
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

}

