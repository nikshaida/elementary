package com.softserve.elementary.task_01;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeskTest {
    Desk desk;
    @Before
    public void greateDefaultDesk() {
       desk = new Desk(2, 2);
    }

    @Test
    public void makeDeskInStringTest() {
        //GIVEN
        int expectedLength = 6;
        String expectedString = "* \n *\n";
        //WHEN
        String res = desk.makeDeskInString();
        int resLength = res.length();
        //THEN
        Assert.assertEquals(expectedLength, resLength);
        Assert.assertEquals(expectedString, res);
    }

    public void checkWidthandHightTest(){
        //GIVEN
        int expectedWidth = 2;
        int expectedHeight = 2;
        //WHEN
        int resWidth = desk.getWidth();
        int resHeight = desk.getHeight();
        //THEN
        Assert.assertEquals(expectedHeight, resHeight);
        Assert.assertEquals(expectedWidth, resWidth);
    }


}