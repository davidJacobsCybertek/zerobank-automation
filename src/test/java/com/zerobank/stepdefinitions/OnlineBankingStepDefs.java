package com.zerobank.stepdefinitions;

import com.zerobank.pages.OnlineBankingPage;
import io.cucumber.java.en.When;

public class OnlineBankingStepDefs {
    @When("the user navigates to Account Summary page")
    public void the_user_navigates_to_Account_Summary_page() {
       new OnlineBankingPage().AccountSummaryLink.click();
    }

    @When("the user navigates to Account Activity page")
    public void the_user_navigates_to_Account_Activity_page() {
        new OnlineBankingPage().AccountActivityLink.click();
    }

    @When("the user navigates to PayyBill page")
    public void the_user_navigates_to_PayyBill_page() {
        new OnlineBankingPage().PayBillsLink.click();
    }
}
