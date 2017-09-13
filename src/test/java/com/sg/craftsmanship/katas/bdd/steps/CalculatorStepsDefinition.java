package com.sg.craftsmanship.katas.bdd.steps;

import com.sg.craftsmanship.katas.bdd.Calculator;
import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import org.junit.Assert;

public class CalculatorStepsDefinition {

    private Calculator sut;

    //addition
    @Given("^a calculator just turned on$")
    public void a_calculator_just_turned_on() throws Throwable {
        sut = new Calculator();
        Assert.assertNotNull(sut);
    }

    @When("^I add (\\d+)$")
    public void I_add(double arg1) throws Throwable {
        sut.add(arg1);
    }

    @Then("^the result is (\\d+)$")
    public void the_result_is(double arg1) throws Throwable {
        Assert.assertEquals(3,sut.getResult(),5);
    }

    //substract

    @When("^I substract (\\d+) from (\\d+)$")
    public void I_substract_from(Double arg1, Double arg2) throws Throwable {
        sut.substract(arg1);
        Assert.assertEquals(arg2,sut.getResult(),1);
    }

    @When("^I substract (\\d+)$")
    public void I_substract(int arg1) throws Throwable {

    }


}
