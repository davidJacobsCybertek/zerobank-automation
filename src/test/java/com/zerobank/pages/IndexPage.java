package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

    public IndexPage(){

        PageFactory.initElements(Driver.get(), this);
    }

@FindBy(css = "a#online-banking")
    public WebElement moreServicesButton;

}
