package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {



    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));

    }


    @When("the user enters valid keys")
    public void the_user_enters_valid_keys() {
        //BrowserUtils.waitFor(3);
//        System.out.println("username = " + username);
//        System.out.println("pass = " + password);
//        System.out.println("confusername = " + ConfigurationReader.get("username"));
//        System.out.println("confpass = " + ConfigurationReader.get("password"));

        new LoginPage().username.sendKeys(ConfigurationReader.get("username"));
        new LoginPage().password.sendKeys(ConfigurationReader.get("password"));
        new LoginPage().signIn.click();
        Driver.get().navigate().back();

        //new LoginPage().BackToSafetyButton.click();
    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        Assert.assertEquals("verify url","http://zero.webappsecurity.com/index.html",Driver.get().getCurrentUrl());
    }

    @When("the user enters invalid keys like {string} {string}")
    public void the_user_enters_invalid_keys_like(String username, String password) {
        new LoginPage().username.sendKeys(username);
        new LoginPage().password.sendKeys(password);
        new LoginPage().signIn.click();
    }



    @Then("error message occurs")
    public void error_message_occurs() {
        Assert.assertEquals("verify error message","Login and/or password are wrong.",new LoginPage().loginError.getText().trim());
    }

    @When("User does nor enter valid keys but click SignIn")
    public void user_does_nor_enter_valid_keys_but_click_SignIn() {
        new LoginPage().signIn.click();
    }

}
