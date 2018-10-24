package com.softserve.elementary.task_07;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void getMax() {
        //GIVEN
        int expected = 5;
        //THEN
        int res = App.getMax(27);
        //
        Assert.assertEquals(expected, res);
    }

    @Test
    public void getStringResult() {
        //GIVEN
        String  expected = "1, 2, 3, 4, 5";
        //THEN
        String res = App.getStringResult(App.getMax(27));
        //
        Assert.assertEquals(expected, res);

    }
}
