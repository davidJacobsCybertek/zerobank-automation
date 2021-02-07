package com.zerobank.stepdefinitions;

import com.zerobank.pages.IndexPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.OnlineBankingPage;
import com.zerobank.pages.PayBillPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class AddNewPayeeStepDefs {
PayBillPage payBillPage=new PayBillPage();
    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        Driver.get().get(ConfigurationReader.get("url"));
        new LoginPage().username.sendKeys(ConfigurationReader.get("username"));
        new LoginPage().password.sendKeys(ConfigurationReader.get("password"));
        new LoginPage().signIn.click();
        new LoginPage().BackToSafetyButton.click();
        new IndexPage().moreServicesButton.click();
        new OnlineBankingPage().PayBillsLink.click();
        payBillPage.addNewPayee.click();
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> payee) {
        payBillPage.nameOfPayee.sendKeys(payee.get("Payee Name"));
        payBillPage.addressOfPayee.sendKeys(payee.get("Payee Address"));
        payBillPage.accountOfPayee.sendKeys(payee.get("Account"));
        payBillPage.detailsOfPayee.sendKeys(payee.get("Payee details"));
        payBillPage.addNewPayeeButton.click();
    }
    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String message) {

        Assert.assertEquals("verify message",message,payBillPage.messageOfPayeeCreated.getText());
    }

}
