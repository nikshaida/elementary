package com.softserve.elementary.task_06;

import com.softserve.elementary.task_06.Exceptions.MyException;
import com.softserve.elementary_tasks.consoleHelper.ConsoleHelper;

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
    private static final String START_MESS = "Please print path to File with algorithm";
    private static final String MOSCOW = "Moscow";
    private static final String DNEPR = "DNEPR";
    private static final String PETER = "Peter";
    private static final String PROBLEM_FILE = "I cant find file with algorithm";
    private static final String FOR_ALGORITHM = "Count for algorithm what was choosen: ";
    private static final String NO_ALGORITHM = "Sorry but we don't no anything about this algorithm";



    public static void main( String[] args )
    {
        BufferedReader reader;
        String fileWithAlgoritm;
        String algorithm = "";
        LuckyTickets luckyTickets;
        //String type;
        File file;
        ConsoleHelper.writeMessage(START_MESS);
        fileWithAlgoritm = ConsoleHelper.readString();
        try {

            file = new File(fileWithAlgoritm);
            reader = new BufferedReader(new FileReader(file));
            algorithm = reader.readLine();

        } catch (FileNotFoundException e ) {
            ConsoleHelper.writeMessage(PROBLEM_FILE);

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (isAlgoritmPresent(algorithm)) {
            luckyTickets = new LuckyTickets(algorithm);
            ConsoleHelper.writeMessage(FOR_ALGORITHM + algorithm + luckyTickets.getResult());
        }
        else {
            ConsoleHelper.writeMessage(NO_ALGORITHM);
        }

    }

    private static boolean isAlgoritmPresent(String algorithm){
        boolean res = true;
        if  (!algorithm.equalsIgnoreCase(MOSCOW) || !algorithm.equalsIgnoreCase(PETER)
                || !algorithm.equalsIgnoreCase(DNEPR)) {
            res = false;
        }
            return res;
    }



}
