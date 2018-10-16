package com.softserve.elementary.task_03;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private static final String TEST_STRING = "nik, 5,5,5";
    private static final String TEST_STRING_WRONG = "nik, a,d,5";
    private static final String TEST_STRING_WRONG_SIZE = "nik, 10,15,45";
    /**
     * Rigorous Test :-)
     */
    @Rule
    public ExpectedException expectedException = ExpectedException.none();



    @Test
    public void getSides() {
        //GIVEN
        double [] expected = {5.0, 5.0 ,5.0};
        //WHEN
        double [] res = App.getSides(TEST_STRING.split(","));
        //THEN
        Assert.assertNotNull(res);
        Assert.assertArrayEquals(expected, res, 0.0);
    }

    @Test
    public void getSidesNegative() {
        //GIVEN
        expectedException.expect(IllegalArgumentException.class);
        //WHEN
        double [] res = App.getSides(TEST_STRING_WRONG.split(","));

    }


    @Test
    public void makeTriangle() {
        //GIVEN
        Triangle expected = new Triangle("nik", 5,5,5);
        //WHEN
        Triangle res = App.makeTriangle(TEST_STRING.split(","));
        //THEN
        Assert.assertNotNull(res);
        Assert.assertEquals(expected, res);
    }


    @Test
    public void makeTriangleWithInvalidSize() {
        //GIVEN
        expectedException.expect(IllegalArgumentException.class);
        //WHEN
        Triangle res = App.makeTriangle(TEST_STRING_WRONG_SIZE.split(","));

    }
}

