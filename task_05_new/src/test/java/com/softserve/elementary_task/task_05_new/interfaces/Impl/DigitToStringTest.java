package com.softserve.elementary_task.task_05_new.interfaces.Impl;

import com.softserve.elementary_task.task_05_new.interfaces.PrinteredDigits;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class DigitToStringTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();


    @Test
    public void getResultFirstTenTest() {
        //GIVEN
       String expected = "одинадцать ";

        //WHEN
        PrinteredDigits printeredDigits = new DigitToString("11");
        String  res = printeredDigits.getResult();
        //THEN
        Assert.assertEquals(expected, res);
    }

    @Test
    public void getResultHundredTest() {
        //GIVEN
        String expected = "сто двадцать один ";

        //WHEN
        PrinteredDigits printeredDigits = new DigitToString("121");
        String  res = printeredDigits.getResult();
        //THEN
        Assert.assertEquals(expected, res);
    }

    @Test
    public void getResultThousandTest() {
        //GIVEN
        String expected = "сто двадцать одна тысяча сто двадцать один ";

        //WHEN
        PrinteredDigits printeredDigits = new DigitToString("121121");
        String  res = printeredDigits.getResult();
        //THEN
        Assert.assertEquals(expected, res);
    }

    @Test
    public void getResultMillionTest() {
        //GIVEN
        String expected = "один миллион сто двадцать одна тысяча сто двадцать один ";

        //WHEN
        PrinteredDigits printeredDigits = new DigitToString("1121121");
        String  res = printeredDigits.getResult();
        //THEN
        Assert.assertEquals(expected, res);
    }

    @Test
    public void getResultBillionTest() {
        //GIVEN
        String expected = "одинадцать миллиардов тринадцать миллионов двести тринадцать тысяч сто тридцать один ";

        //WHEN
        PrinteredDigits printeredDigits = new DigitToString("11013213131");
        String  res = printeredDigits.getResult();
        //THEN
        Assert.assertEquals(expected, res);
    }

    @Test
    public void getResultMinusTest() {
        //GIVEN
        String expected = "минус тринадцать ";

        //WHEN
        PrinteredDigits printeredDigits = new DigitToString("-13");
        String  res = printeredDigits.getResult();
        //THEN
        Assert.assertEquals(expected, res);
    }


    @Test
    public void getNegativeTest() {
        //GIVEN
        expectedException.expect(NumberFormatException.class);

        //WHEN
        PrinteredDigits printeredDigits = new DigitToString("adsdasd");
        printeredDigits.getResult();


    }



}