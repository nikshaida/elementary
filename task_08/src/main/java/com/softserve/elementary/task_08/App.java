package com.softserve.elementary.task_08;

/**
 *
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       if (args.length !=2){
            System.out.println("You have to specify range");
            return;
        }

        try {
            int start = Integer.parseInt(args[0]);
            int finish = Integer.parseInt(args[1]);




            if (start < 0 || finish <=0){
                System.out.println("You digit must be bigger then zero");
                return;
            }

            printRangeOfFib(start, finish);

        } catch (NumberFormatException e ){
            System.out.println("you have to use digit");
        }

    }

    public static void printRangeOfFib(int startRange, int endRange){
        StringBuilder stringBuilder = new StringBuilder();
        long fib = 0;
        if ( (endRange - startRange) < startRange || startRange > endRange ){
            System.out.println("No digit in this range");
            return;
        }
            for (int i =1; i < endRange; i++){
                fib = fibDigit(i);
                if (fib > endRange) break;
                if ((fib = fibDigit(i)) > startRange) stringBuilder.append(fib + ", ");

            }
        System.out.println(stringBuilder.substring(0, stringBuilder.lastIndexOf(", ")));

    }

    public static int fibDigit(int n) {
        int first = 0;
        int second = 1;
        /*for (int i = 1; i < n; i++) {
            res = first+second;
            first=second;
            second=res;
        }*/
        for (int i = 1; i < n; i++){
            second=first+second;
            first=second-first;
        }

        return second;
    }

}
