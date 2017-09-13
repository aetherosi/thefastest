package com.sg.craftsmanship.katas.bdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.containsString;

public class CalculatorTest{

    private Calculator sut;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void init(){
        sut = new Calculator();
    }
    @Test
    public void sutShouldNotBeNull(){
        Assert.assertNotNull(sut);
    }

    @Test
    public void setOperatorShouldSetNextOperatorAsPlus() {
        sut.setOperator(Operators.Plus);
        Assert.assertEquals(Operators.Plus, sut.getOperator());
    }

    @Test
    public void setOperatorShouldSetNextOperatorAsMinus() {
        sut.setOperator(Operators.Minus);
        Assert.assertEquals(Operators.Minus, sut.getOperator());
    }

    @Test
    public void setOperatorShouldSetNextOperatorAsMultiply() {
        sut.setOperator(Operators.Multiply);
        Assert.assertEquals(Operators.Multiply, sut.getOperator());
    }

    @Test
    public void setOperatorShouldSetNextOperatorAsDivide() {
        sut.setOperator(Operators.Divide);
        Assert.assertEquals(Operators.Divide, sut.getOperator());
    }

    @Test
    public void setOperatorShouldSetNextOperatorAsEqual() {
        sut.setOperator(Operators.Equal);
        Assert.assertEquals(Operators.Equal, sut.getOperator());
    }

    @Test
    public void sutShouldAdd3And3AndReturnResultsAs6() {
        sut.operate(3d, Operators.Plus);
        sut.operate(3d, Operators.Plus);
        Assert.assertTrue(sut.getResult() == 6d);
    }

    @Test
    public void sutShouldSubstract2From3AndReturnResultsAs1() {
        sut.operate(3d, Operators.None);
        sut.operate(2d, Operators.Minus);
        Assert.assertTrue(sut.getResult() == 1d);
    }

    @Test
    public void sutShouldMultiply2by3AndReturnResultsAs6() {
        sut.operate(2d, Operators.None);
        sut.operate(3d, Operators.Multiply);
        Assert.assertTrue(sut.getResult() == 6d);
    }

    @Test
    public void sutShouldThrowArithmeticExceptionWhenDividingBy0() {
        thrown.expect(ArithmeticException.class);
        thrown.expectMessage(containsString("Cannot divide by zero"));

        sut.operate(6d, Operators.None);
        sut.operate(0, Operators.Divide);
    }

    @Test
    public void sutShouldDivide6by3AndReturnResultsAs2() {
        sut.operate(6d, Operators.None);
        sut.operate(3d, Operators.Divide);
        Assert.assertTrue(sut.getResult() == 2d);
    }

    @Test
    public void sutShouldClearResults(){
        sut.operate(1d, Operators.Plus);
        Assert.assertEquals(1d ,sut.getResult(),0.1);
        sut.clear();
        Assert.assertEquals(0d,sut.getResult(),0.1);
    }

    /*@Test
    public void sutShouldPrintOperationsSequence(){
        String actual = sut.getOperationsSequence();
        Assert.assertEquals();
    }

    @Test
    public void sutShouldSubstract1from5andResultIs4(){
        clear();
        sut.add(5d);
        sut.substract(1d);
        Assert.assertEquals(4d,sut.getResult(),0.1);
    }

    @Test
    public void sutShouldSubstract2from4andResultIs2(){
        clear();
        sut.add(4d);
        sut.substract(2d);
        Assert.assertEquals(2d,sut.getResult(),0.1);
    }
*/

}

