package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){

        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "input#user_login")
    public WebElement username;


    @FindBy(css = "input#user_password")
    public WebElement password;

    @FindBy(xpath = "//input[@name='submit']")
    public WebElement signIn;
    @FindBy(css = "div.alert.alert-error")
    public WebElement loginError;
    @FindBy(css = "#primary-button")
    public WebElement BackToSafetyButton;

}