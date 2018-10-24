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


public class LuckyTickets {
    private static final int DEFAULT_TYPE = 6;
    private static final int MAX_DIGIT_IN_ROW = 9;
    private String algorithmName;
    private int type;


    public LuckyTickets() {
        this.type = DEFAULT_TYPE;
    }

    public LuckyTickets(String algorithmName) {
        this.algorithmName = algorithmName;
        this.type = DEFAULT_TYPE;
    }

    public LuckyTickets(String algorithmName, int type) {
        this.algorithmName = algorithmName;
        this.type = type;
    }


    private int getMoscowUseRecAndCombi(){
        int res = 0;
        for (int i = 0; i <=countMaxSum(); ++i ){
            int variantForTicket = variantForTicket(type/2, i);
            res+=variantForTicket*variantForTicket;
        }
        return res;
    }


    //count variant of lucky combination for sum
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

    //counting variant of numbers of ticket
    private int countVariant() {
        int res = 1;
        for (int i = 0; i < type; i++) {
            res *= 10;
        }
        return res;
    }
    //count max sum of half part of ticket
    private int countMaxSum(){
        return (type/2)*MAX_DIGIT_IN_ROW;
    }


    private int[] numberToDigitArr(int number){
        int [] digitsArr = {0,0,0,0,0,0};
        //  I try to fil my arr from begining but for this i have to use a lot of args
        int positionOfDigit = digitsArr.length-1;

        while (number > 0){
            digitsArr[positionOfDigit] = number % 10;
            number = number / 10;
            positionOfDigit--;
        }

        return digitsArr;
    }

    private boolean isLuckyTicketPeter(int number){
        int [] arr = numberToDigitArr(number);
        return (arr[0] + arr[2] + arr[4]) == (arr[1] + arr[3] + arr[5]);

    }

    private boolean isLuckyTicketDnepr(int number){
        int [] arr = numberToDigitArr(number);
        int odd = 0;
        int even = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] % 2 ==0 ) {
             even+=arr[i];
            } else {
                odd+=arr[i];
            }
        }
        return odd == even;
    }

    private int getPeter(){
        int res = 0;
        for (int i = 0; i < countVariant(); i++){
            if (isLuckyTicketPeter(i)) res++;
        }
        return res;
    }

    private int getDnepr(){
        int res = 0;
        for (int i = 0; i < countVariant(); i++){
            if (isLuckyTicketDnepr(i)) res++;
        }
        return res;
    }


    public int getResult(){
        if (algorithmName.equalsIgnoreCase("Moscow")){
            return getMoscowUseRecAndCombi();
        }  else if (algorithmName.equalsIgnoreCase("Dnepr")){
            return getDnepr();
        } else {
            return getPeter();
        }
    }
}

