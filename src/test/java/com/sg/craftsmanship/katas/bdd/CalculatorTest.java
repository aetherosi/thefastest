package com.sg.craftsmanship.katas.bdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest{

    private Calculator sut;

    @Before
    public void init(){
        sut = new Calculator();
    }
    @Test
    public void sutShouldNotBeNull(){
        Assert.assertNotNull(sut);
    }
    @Test
    public void sutShouldPushNumber(){
        sut.add(3d);
        sut.add(3d);
        Assert.assertTrue(sut.getResult() == 6d);
    }

    @Test
    public void sutShouldReturnResults(){
        sut.add(3d);
        sut.add(3d);
        Assert.assertTrue(sut.getResult() == 6d);
    }

    @Test
    public void sutShouldClearResults(){
        sut.add(1d);
        Assert.assertEquals(1d ,sut.getResult(),0.1);
        sut.clear();
        Assert.assertEquals(0d,sut.getResult(),0.1);
    }
    /*
    @Test
    public void sutShouldSubstract1from5andResultIs4(){
        clear();
        sut.add(5d);
        sut.substract(1d);
        Assert.assertEquals(4d,sut.getResult());
    }

    @Test
    public void sutShouldSubstract1from4andResultIs4(){
        sut.substract(2d);
        Assert.assertEquals(4d,sut.getResult(),0.1);
    }

    @Test
    public void sutShouldSubstract1from4andResultIs3(){
        sut.substract(1d);
        Assert.assertEquals(3d,sut.getResult());

    }
    */
    //utils
    private void clear(){
        sut.clear();
    }


}

