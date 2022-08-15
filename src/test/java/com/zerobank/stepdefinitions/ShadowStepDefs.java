package com.zerobank.stepdefinitions;

import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class ShadowStepDefs {

    @Given("the user goes to url")
    public void the_user_goes_to_url() {
       Driver.get().get("https://letcode.in/shadow");
        //Driver.get().get("https://www.mercedes-benz.co.uk/passengercars.html?group=all&subgroup=see-all&view=BODYTYPE");
    }



    @When("the user clicks accepAll")
    public void the_user_clicks_accepAll() throws InterruptedException {
        JavascriptExecutor jse=(JavascriptExecutor)Driver.get();
        String str1= "document.querySelector(\"body > cmm-cookie-banner\").shadowRoot.querySelector(\"div > div > div.cmm-cookie-banner__content > div.toggle-buttons-wrapper > div > button.wb-button.wb-button--primary.wb-button--small.wb-button--accept-all\")";
       // String str="return document.querySelector(\"#open-shadow\").shadowRoot.querySelector(\"#fname\")";


        WebElement inputBox = (WebElement) jse.executeScript("document.querySelector('#open-shadow').shadowRoot.querySelector('#fname')");
        Thread.sleep(5000);
            inputBox.sendKeys("david");

        // jse.executeScript("document.querySelector('body > cmm-cookie-banner').shadowRoot.querySelector('div > div > div.cmm-cookie-banner__content > div.toggle-buttons-wrapper > div > button.wb-button.wb-button--primary.wb-button--small.wb-button--accept-all').click()");
        //"document.querySelector('body > cmm-cookie-banner').shadowRoot.querySelector('div > div > div.cmm-cookie-banner__content > div.toggle-buttons-wrapper > div > button.wb-button.wb-button--primary.wb-button--small.wb-button--accept-all')"

        //firstName.sendKeys("david");
//firstName.click();
    }
    @Then("the user lands in homepage")
    public void the_user_lands_in_homepage() {
        Assert.assertEquals(Driver.get().getTitle(),"Mercedes-Benz Passenger Cars");
    }


}
