package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTransactionsStepDefs {
    AccountActivityPage activity = new AccountActivityPage();

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        activity.findTrasactionsLink.click();
    }
    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {

        activity.fromDate.clear();
        activity.fromDate.sendKeys(fromDate);
        activity.toDate.clear();
        activity.toDate.sendKeys(toDate);

    }
    @When("clicks search")
    public void clicks_search() {
        activity.findButton.click();
        BrowserUtils.waitFor(1);
    }
    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) {

        List<String> transactionDates=activity.findTransactionDates();
        for (String transactionDate : transactionDates) {
            for (int i = 0; i < 3; i++) {
                Assert.assertTrue("verify from date",activity.dateToIntArrayConverter(transactionDate)[i] >= activity.dateToIntArrayConverter(fromDate)[i]);
                //System.out.println(activity.dateToIntArrayConverter(transactionDate)[i]+" >= "+ activity.dateToIntArrayConverter(fromDate)[i]);
                Assert.assertTrue("verify to date",activity.dateToIntArrayConverter(transactionDate)[i] <= activity.dateToIntArrayConverter(toDate)[i]);
                //System.out.println(activity.dateToIntArrayConverter(transactionDate)[i]+" <= "+ activity.dateToIntArrayConverter(toDate)[i]);
            }
        }
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        List<String> transactionDates=activity.findTransactionDates();
        for (int i = 0; i < transactionDates.size()-1; i++) {
            for (int j = 0; j < 3; j++) {
          Assert.assertTrue(activity.dateToIntArrayConverter(transactionDates.get(i))[j]>=activity.dateToIntArrayConverter(transactionDates.get(i+1))[j]);
                System.out.println(activity.dateToIntArrayConverter(transactionDates.get(i))[j]+"  >=  "+activity.dateToIntArrayConverter(transactionDates.get(i+1))[j]);
        }
        }

    }
    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String date) {
        List<String> transactionDates=activity.findTransactionDates();
        Assert.assertFalse(transactionDates.contains(date));
    }
}
