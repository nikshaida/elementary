package com.softserve.elementary.task_02;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class AppTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();



    @Test
    public void isFit() {
        //GIVEN
        Envelope envelope1 = new Envelope(5.5, 5.5);
        Envelope envelope2 = new Envelope(5, 5);
        boolean expected = true;
        //WHEN
        boolean res = App.isFit(envelope1, envelope2);
        //THEN
        Assert.assertEquals(expected, res);
    }

    @Test
    public void makeEnvelope() {
        //GIVEN
        Envelope expectedEnvelope = new Envelope(2.2, 2.2);
        //WHEN
        Envelope res = App.makeEnvelope(2.2, 2.2);
        //THEN
        Assert.assertEquals(expectedEnvelope, res);


    }

    @Test
    public void makeEnvelopeNegative() {
        //GIVEN
        expectedException.expect(IllegalArgumentException.class);
        //WHEN
        Envelope res = App.makeEnvelope(-2, 2.2);
        //THEN


    }
}