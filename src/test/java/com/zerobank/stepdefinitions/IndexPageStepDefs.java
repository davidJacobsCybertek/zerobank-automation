package com.zerobank.stepdefinitions;

import com.zerobank.pages.IndexPage;
import io.cucumber.java.en.When;

public class IndexPageStepDefs {

    @When("the user navigates to Online Banking page")
    public void the_user_navigates_to_Online_Banking_page() {
        new IndexPage().moreServicesButton.click();
    }
}
