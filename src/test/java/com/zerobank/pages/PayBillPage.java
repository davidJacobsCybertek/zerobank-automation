package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayBillPage {
    public PayBillPage(){
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(css = "#sp_payee")
    public WebElement PayeeSelection;

    @FindBy(css = "#sp_account")
    public WebElement AccountSelection;

    @FindBy(css = "#sp_amount")
    public WebElement amount;

    @FindBy(css = "#sp_date")
    public WebElement date;

    @FindBy(css = "#sp_description")
    public WebElement description;

    @FindBy(css = "#pay_saved_payees")
    public WebElement payButton;

    @FindBy(css = "div#alert_content>span")
    public WebElement submitApprovalMessage;




}
