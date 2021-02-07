package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OnlineBankingPage {

    public OnlineBankingPage() {
        PageFactory.initElements(Driver.get(), this);
    }

@FindBy(css = "span#account_summary_link")
    public WebElement AccountSummaryLink;


    @FindBy(css = "span#account_activity_link")
    public WebElement AccountActivityLink;

    @FindBy(css = "span#pay_bills_link")
    public WebElement PayBillsLink;



}
