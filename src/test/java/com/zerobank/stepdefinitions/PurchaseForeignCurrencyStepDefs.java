package com.zerobank.stepdefinitions;

import com.zerobank.pages.IndexPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.OnlineBankingPage;
import com.zerobank.pages.PayBillPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PurchaseForeignCurrencyStepDefs {
PayBillPage payBillPage=new PayBillPage();
    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
        Driver.get().get(ConfigurationReader.get("url"));
        new LoginPage().username.sendKeys(ConfigurationReader.get("username"));
        new LoginPage().password.sendKeys(ConfigurationReader.get("password"));
        new LoginPage().signIn.click();
        new LoginPage().BackToSafetyButton.click();
        new IndexPage().moreServicesButton.click();
        new OnlineBankingPage().PayBillsLink.click();
        payBillPage.PurchaseForeignCurrencyLink.click();
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> expectedcurrencies) {
    Select currencies= new Select(payBillPage.currencyOptions);
    List<WebElement> actualCurrencies=currencies.getOptions();
    List<String> actualCurrenciesInString=BrowserUtils.getElementsText(actualCurrencies);
    actualCurrenciesInString.remove(0);
        System.out.println("actualCurrenciesInString = " + actualCurrenciesInString.toString());
        Assert.assertEquals("verify currencies are available",expectedcurrencies,actualCurrenciesInString);

    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        payBillPage.CalculateCostButton.click();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Alert alert =Driver.get().switchTo().alert();
        //System.out.println("alert.getText() = " + alert.getText());
        String expectedErrorMessage="Please, ensure that you have filled all the required fields with valid values.";
        Assert.assertEquals("verify error messages",expectedErrorMessage,alert.getText());
        alert.accept();
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        Select currencies= new Select(payBillPage.currencyOptions);
        currencies.selectByIndex(5);
        //payBillPage.AmountCurrency.sendKeys("10");
        payBillPage.radioSelectedCurrency.click();
        payBillPage.CalculateCostButton.click();
    }

}
