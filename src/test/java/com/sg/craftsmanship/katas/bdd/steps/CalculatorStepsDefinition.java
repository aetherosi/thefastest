package com.sg.craftsmanship.katas.bdd.steps;

import com.sg.craftsmanship.katas.bdd.Calculator;
import com.sg.craftsmanship.katas.bdd.Operators;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static com.sg.craftsmanship.katas.bdd.Operators.*;

public class CalculatorStepsDefinition {

    private Calculator sut;
    private String errorMessage;

    @Before
    public void init() {
        sut = new Calculator();
    }

    //Turn on / reset
    @Given("^a calculator just turned on$")
    public void a_calculator_just_turned_on() throws Throwable {
        Assert.assertNotNull(sut);
    }

    @Given("^a calculator just reseted$")
    public void a_calculator_just_reseted() throws Throwable {
        Assert.assertNotNull(sut);
        sut.clear();
    }

    //add
    @When("^I add (\\d+)$")
    public void I_add(double arg1) throws Throwable {
        sut.operate(arg1, Plus);
    }

    @Then("^the result is (\\d+)$")
    public void the_result_is(double arg1) throws Throwable {
        Assert.assertEquals(arg1, sut.getResult(), 5);
    }
    //substract
    @When("^I substract (\\d+) from (\\d+)$")
    public void I_substract_from(double arg1, double arg2) throws Throwable {
        sut.operate(arg2, None);
        sut.operate(arg1, Minus);
        Assert.assertEquals(2, sut.getResult(), 0.1);
    }

    @When("^I substract (\\d+)$")
    public void I_substract(double arg1) throws Throwable {
        sut.operate(arg1, Minus);
    }

    //multiply
    @When("^I multiply (\\d+) with (\\d+)$")
    public void I_multiply_with(double arg1, double arg2) throws Throwable {
        sut.operate(arg1, None);
        sut.operate(arg2, Multiply);
        Assert.assertEquals(6, sut.getResult(), 0.1);
    }

    @When("^I multiply by (\\d+)$")
    public void I_multiply_by(double arg1) throws Throwable {
        sut.operate(arg1, Multiply);
        Assert.assertEquals(12, sut.getResult(), 0.1);
    }

    @When("^I divide (\\d+) by (\\d+)$")
    public void I_divide_by(int arg1, int arg2) throws Throwable {
        sut.operate(arg1, None);
        sut.operate(arg2, Divide);
        Assert.assertEquals(3, sut.getResult(), 0.1);
    }

    @When("^I divide by (\\d+)$")
    public void I_divide_by(int arg1) throws Throwable {
        sut.operate(arg1, Divide);
        Assert.assertEquals(1.5, sut.getResult(), 0.1);
    }

    @Then("^the result is \"([^\"]*)\"$")
    public void the_result_is(String arg1) throws Throwable {
        Assert.assertEquals(Double.parseDouble(arg1), sut.getResult(), 0.1);
    }

    @When("^I divide \"([^\"]*)\"$")
    public void I_divide(String arg1) throws Throwable {
        try {
            sut.operate(6d, Operators.None);
            sut.operate(0, Operators.Divide);
        } catch (ArithmeticException e) {
            errorMessage = e.getMessage();
        }
    }

    @Then("^an error with the Message \"([^\"]*)\" should occur$")
    public void an_error_with_the_Message_should_occur(String arg1) throws Throwable {
        Assert.assertTrue(errorMessage.equals(arg1));
    }



}
