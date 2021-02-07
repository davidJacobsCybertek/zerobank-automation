package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FindTransactionsStepDefs {
    AccountActivityPage activityPage = new AccountActivityPage();

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        activityPage.findTrasactionsLink.click();
    }
    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {

        activityPage.fromDate.clear();
        activityPage.fromDate.sendKeys(fromDate);
        activityPage.toDate.clear();
        activityPage.toDate.sendKeys(toDate);

    }
    @When("clicks search")
    public void clicks_search() {
        activityPage.findButton.click();
        BrowserUtils.waitFor(1);
    }
    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) {

        List<String> transactionDates= activityPage.findTransactionDates();
        for (String transactionDate : transactionDates) {
            for (int i = 0; i < 3; i++) {
                Assert.assertTrue("verify from date", activityPage.dateToIntArrayConverter(transactionDate)[i] >= activityPage.dateToIntArrayConverter(fromDate)[i]);
                //System.out.println(activity.dateToIntArrayConverter(transactionDate)[i]+" >= "+ activity.dateToIntArrayConverter(fromDate)[i]);
                Assert.assertTrue("verify to date", activityPage.dateToIntArrayConverter(transactionDate)[i] <= activityPage.dateToIntArrayConverter(toDate)[i]);
                //System.out.println(activity.dateToIntArrayConverter(transactionDate)[i]+" <= "+ activity.dateToIntArrayConverter(toDate)[i]);
            }
        }
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        List<String> transactionDates= activityPage.findTransactionDates();
        for (int i = 0; i < transactionDates.size()-1; i++) {
            for (int j = 0; j < 3; j++) {
          Assert.assertTrue(activityPage.dateToIntArrayConverter(transactionDates.get(i))[j]>= activityPage.dateToIntArrayConverter(transactionDates.get(i+1))[j]);
                System.out.println(activityPage.dateToIntArrayConverter(transactionDates.get(i))[j]+"  >=  "+ activityPage.dateToIntArrayConverter(transactionDates.get(i+1))[j]);
        }
        }

    }
    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String date) {
        List<String> transactionDates= activityPage.findTransactionDates();
        Assert.assertFalse(transactionDates.contains(date));
    }
    @When("the user enters description {string}")
    public void the_user_enters_description(String description) {
        activityPage.description.clear();
        activityPage.description.sendKeys(description);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String description) {
        List<String> transactionDescriptions = activityPage.findTransactionDescriptions();
        for (String transactionDescription : transactionDescriptions) {
            Assert.assertTrue(transactionDescription.contains(description));
        }

    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String description) {
        List<String> transactionDescriptions = activityPage.findTransactionDescriptions();
        for (String transactionDescription : transactionDescriptions) {
            Assert.assertFalse(transactionDescription.contains(description));

        }

    }

    @Then("results table should show at least one result under {string}")
    public void results_table_should_show_at_least_one_result_under(String account) {
        List<String> amounts = activityPage.findAmounts(account);
        Assert.assertTrue(amounts.size()>0);
    }
    @When("user selects type {string}")
    public void user_selects_type(String account) {
        Select typeOptions=new Select(activityPage.typeOptions);
        typeOptions.selectByVisibleText(account);
        activityPage.findButton.click();
    }
    @Then("results table should show no result under {string}")
    public void results_table_should_show_no_result_under(String account) {
        List<String> amounts = activityPage.findAmounts(account);
        Assert.assertTrue(amounts.size()==0);
    }

}
