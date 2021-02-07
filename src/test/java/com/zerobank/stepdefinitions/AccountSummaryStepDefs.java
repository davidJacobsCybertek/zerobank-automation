package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AccountSummaryStepDefs {


    @Then("the page title is {string}")
    public void the_page_title_is(String expectedTitle) {
        Assert.assertEquals("verify titile",expectedTitle,Driver.get().getTitle());
    }

    @Then("the page should have following account types")
    public void the_page_should_have_following_account_types(List<String> accountNames) {
        Assert.assertEquals("verify Accounts on page",accountNames,BrowserUtils.getElementsText(new AccountSummaryPage().accountTypes));
    }

    @Then("the credit account colums are like following")
    public void the_credit_account_colums_are_like_following(List<String> creditAccountColumns) {
        Assert.assertEquals("verify credit account columns",creditAccountColumns,BrowserUtils.getElementsText(new AccountSummaryPage().CreditCardAccountHeaders));
    }
}
