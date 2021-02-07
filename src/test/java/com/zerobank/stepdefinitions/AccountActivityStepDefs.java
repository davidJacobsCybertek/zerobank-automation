package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class AccountActivityStepDefs {

    Select accountOptions=new Select(new AccountActivityPage().accounts);
    List<WebElement> options=accountOptions.getOptions();



    @Then("the user see the page title is {string}")
    public void the_user_see_the_page_title_is(String expectedTitle) {
        Assert.assertEquals("verify page title",expectedTitle, Driver.get().getTitle());
    }

    @Then("the savings account is selected")
    public void the_savings_account_is_selected() {

        //Select accountOptions=new Select(new AccountActivityPage().accounts);
        //List<WebElement> options=accountOptions.getOptions();
        System.out.println("optionsSize = " + options.size());
        Assert.assertEquals("verify selected","Savings",accountOptions.getFirstSelectedOption().getText());
    }

    @Then("The accounts options should be like")
    public void the_accounts_options_should_be_like(List<String> accountNamesOptions) {

        //savings is duplicated so we have to remove that
        options.remove(2);
        Assert.assertEquals("verify selectable account names",accountNamesOptions,BrowserUtils.getElementsText(options));

    }

    @Then("the transaction table column names are like following")
    public void the_transaction_table_column_names_are_like_following(List<String> transactiontableHeaders) {
        Assert.assertEquals("verify table headers",transactiontableHeaders,BrowserUtils.getElementsText(new AccountActivityPage().accountTableColumns));
    }
}
