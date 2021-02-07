package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountSummaryPage {

    public AccountSummaryPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "h2.board-header")
    public List<WebElement> accountTypes;

    @FindBy(xpath = "(//div[@class='board'])[3]//th")
    public List<WebElement> CreditCardAccountHeaders;

    @FindBy(css = "a[href='/bank/account-activity.html?accountId=1']")
    public WebElement savingsFirstLink;

    @FindBy(css = "a[href='/bank/account-activity.html?accountId=6']")
    public WebElement brokerageLink;

    @FindBy(css = "a[href='/bank/account-activity.html?accountId=2']")
    public WebElement checkingLink;

    @FindBy(css = "a[href='/bank/account-activity.html?accountId=5']")
    public WebElement creditCardLink;

    @FindBy(css = "a[href='/bank/account-activity.html?accountId=4']")
    public WebElement loanLink;


}
