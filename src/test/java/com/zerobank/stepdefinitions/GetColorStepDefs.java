package com.zerobank.stepdefinitions;

import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

public class GetColorStepDefs {


    @Then("the color of the botton is  {string}")
    public void the_color_of_the_botton_is(String colorExpected) {
        WebElement moreServicesButton = Driver.get().findElement(By.id("online-banking"));

        String actualColorRGB = moreServicesButton.getCssValue("background-color");

        System.out.println("actualColorRGB = " + actualColorRGB);

        String actualColorHex = Color.fromString(actualColorRGB).asHex();
        System.out.println("actualColorHex = " + actualColorHex);

        Assert.assertTrue(actualColorHex.equalsIgnoreCase(colorExpected));


        JavascriptExecutor jse= (JavascriptExecutor)Driver.get();
        WebElement button = (WebElement) jse.executeScript("return document.querySelector(\'#online-banking\')");

        button.click();
    }

    }
