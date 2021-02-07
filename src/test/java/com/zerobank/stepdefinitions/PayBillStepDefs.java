package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.Locale;

public class PayBillStepDefs {

    String dateEntered=null;

    @When("the user selects payee")
    public void the_user_selects_payee() {

    }

    @When("the user selects Account")
    public void the_user_selects_Account() {

    }

    @When("the user enters Amount in dollars {string}")
    public void the_user_enters_Amount_in_dollars(String amount) {
        new PayBillPage().amount.sendKeys(amount);
    }

    @When("the user selects date {string}")
    public void the_user_selects_date(String date) {
        new PayBillPage().date.sendKeys(date);
        dateEntered=date;

    }

    @When("the user enters a description")
    public void the_user_enters_a_description() {
        new PayBillPage().description.sendKeys("some description");

    }

    @When("the user clicks pay")
    public void the_user_clicks_pay() {
        new PayBillPage().payButton.click();
    }

    @Then("the user see the message {string}")
    public void the_user_see_the_message(String expectedMessage) {
        Assert.assertEquals("verify submit message", expectedMessage, new PayBillPage().submitApprovalMessage.getText());
    }

    @Then("the user cannot see the message {string}")
    public void the_user_cannot_see_the_message(String expectedMessage) {
        Assert.assertNotEquals("verify submit message", expectedMessage, new PayBillPage().submitApprovalMessage.getText());
    }

    @Then("the user see the {string} error message  {string}")
    public void the_user_see_the_error_message(String dateOrAmount, String expectedErrorMessage) {
//        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
//        jse.executeScript()
        String actualErrormessage = null;
        switch (dateOrAmount.toLowerCase()) {
            case "date":
                actualErrormessage = new PayBillPage().date.getAttribute("validationMessage");
                break;
            case "amount":
                actualErrormessage = new PayBillPage().amount.getAttribute("validationMessage");
                break;
        }

        Assert.assertEquals("verify error message", expectedErrorMessage, actualErrormessage);
    }

    @Then("the user confirms alphabetic characters are not allowed in date field")
    public void the_user_confirms_alphabetic_characters_are_not_allowed_in_date_field() {
//        String dateEntered = dateWithoutAlphabetic;
//        System.out.println("dateEntered = " + dateEntered);
        String dateAccepted = new PayBillPage().date.getAttribute("value");
        System.out.println("dateAccepted = " + dateAccepted);
        System.out.println("dateEntered = " + dateEntered);
        Assert.assertNotEquals("verify tha alphabetic charecters are not allowed", dateEntered, dateAccepted);

    }
}
