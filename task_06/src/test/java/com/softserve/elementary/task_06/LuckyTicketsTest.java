package com.softserve.elementary.task_06;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LuckyTicketsTest {

    @Test
    public void getResultForMoscowTest() {
        //given
        LuckyTickets luckyTickets = new LuckyTickets("moscow");
        int expected = 55252;
        //when
        int res = luckyTickets.getResult();
        //then
        Assert.assertEquals(expected, res);
    }

    @Test
    public void getResultForDnepr() {
        //given
        LuckyTickets luckyTickets = new LuckyTickets("dnepr");
        int expected = 25081;
        //when
        int res = luckyTickets.getResult();
        //then
        Assert.assertEquals(expected, res);
    }


}