package com.softserve.elementary.task_08;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{


    @Test
    public void fibDigit() {
        //GIVEN
        int expected = 13;
        //WHEN
        int res = App.fibDigit(7);
        //THEN
        Assert.assertEquals(expected, res);
    }

    @Test
    public void printRangeOfFib() {
        //GIVEN
        String expected = "8, 13, 21, 34";
        //WHEN
        String res = App.printRangeOfFib(6, 52);
        //THEN
        Assert.assertEquals(expected, res);



    }


}
