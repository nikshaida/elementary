package com.softserve.elementary.task_06;

import com.softserve.elementary.task_06.Exceptions.MyException;

import java.io.*;

/**
 * App
 *
 * Version 1
 *
 *
 * 06.10.2018
 *
 *
 * IT Academy SoftServe
 **/
public class App
{
    public static void main( String[] args )
    {
        BufferedReader reader;
        String fileWithAlgoritm;
        String algorithm = "";
        LuckyTickets luckyTickets;
        //String type;
        File file;
        System.out.println("Please print path to File with algorithm");

        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            fileWithAlgoritm = reader.readLine();
            file = new File(fileWithAlgoritm);
            reader = new BufferedReader(new FileReader(file));
            algorithm = reader.readLine();
            if (!algorithm.equalsIgnoreCase("Moscow") && !algorithm.equalsIgnoreCase("Peter")
                    && !algorithm.equalsIgnoreCase("dnepr")) {
                throw new MyException("I don't know anything about this algorithm");
            }
        } catch (FileNotFoundException e ) {
            System.out.println("I cant find file with algorithm");
            return;
        } catch (MyException e) {
            System.out.println(e.getMessage());
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }

        luckyTickets = new LuckyTickets();

        if (algorithm.equalsIgnoreCase("Moscow")){
            System.out.println("For Moscow algorithm = " + luckyTickets.getMoscow());
        } else if (algorithm.equalsIgnoreCase("Dnepr")){
            System.out.println("For Dnepr algorithm = " + luckyTickets.getDnepr());
        } else {
            System.out.println("For Peter algorithm = " + luckyTickets.getPeter());
        }

    }

}
