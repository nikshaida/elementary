package com.softserve.elementary.task_01;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArgsValidatorTest {



    @Test
    public void checkLength() {
        //GIVEN
        boolean expected = true;
        //WHEN
        boolean res = !ArgsValidator.checkLength( new String[2]);
        //THEN
        Assert.assertEquals(expected, res);
    }
    @Test
    public void checkLengthNegative() {
        //GIVEN
        boolean expected = true;
        //WHEN
        boolean res = ArgsValidator.checkLength( new String[4]);
        //THEN
        Assert.assertEquals(expected, res);
    }


    @Test
    public void isLegalArg() {
        //GIVEN
        boolean expected = true;
        //WHEN
        boolean res = ArgsValidator.isLegalArg(5, 5);
        //THEN
        Assert.assertEquals(expected, res);
    }
    @Test
    public void isLegalArgNegative() {
        //GIVEN
        boolean expected = false;
        //WHEN
        boolean res = ArgsValidator.isLegalArg(-2, 5);
        //THEN
        Assert.assertEquals(expected, res);
    }


}