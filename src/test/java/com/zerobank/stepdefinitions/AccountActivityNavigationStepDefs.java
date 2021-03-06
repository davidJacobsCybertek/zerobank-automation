package com.zerobank.stepdefinitions;

import com.zerobank.pages.*;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityNavigationStepDefs {



    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        Driver.get().get(ConfigurationReader.get("url"));
        new LoginPage().username.sendKeys(ConfigurationReader.get("username"));
        new LoginPage().password.sendKeys(ConfigurationReader.get("password"));
        new LoginPage().signIn.click();
        new LoginPage().BackToSafetyButton.click();
    }

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String accountLink) {
        new IndexPage().moreServicesButton.click();
        new OnlineBankingPage().AccountSummaryLink.click();

        switch (accountLink.toLowerCase()) {
            case "savings":
                new AccountSummaryPage().savingsFirstLink.click();
                break;
            case "brokerage":
                new AccountSummaryPage().brokerageLink.click();
                break;
            case "checking":
                new AccountSummaryPage().checkingLink.click();
                break;
            case "credit card":
                new AccountSummaryPage().creditCardLink.click();
                break;
            case "loan":
                new AccountSummaryPage().loanLink.click();
                break;
        }

    }
    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {
        Assert.assertEquals("verify title","Zero - Account Activity",Driver.get().getTitle());
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String account) {
          Select accountOptions=new Select(new AccountActivityPage().accounts);
          List<WebElement> options=accountOptions.getOptions();
          //System.out.println("accountOptions.getFirstSelectedOption() = " + accountOptions.getFirstSelectedOption().getText());
Assert.assertEquals("verify selected account",account,accountOptions.getFirstSelectedOption().getText());
    }
}
