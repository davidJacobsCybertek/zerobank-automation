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

    @FindBy(css = "a[href='#ui-tabs-2']")
    public WebElement addNewPayee;

    @FindBy(css = "a[href='#ui-tabs-3']")
    public WebElement PurchaseForeignCurrencyLink;

    @FindBy(css = "#np_new_payee_name")
    public WebElement nameOfPayee;

    @FindBy(css = "#np_new_payee_details")
    public WebElement detailsOfPayee;

    @FindBy(css = "#np_new_payee_address")
    public WebElement addressOfPayee;

    @FindBy(css = "#np_new_payee_account")
    public WebElement accountOfPayee;

    @FindBy(css = "#add_new_payee")
    public WebElement addNewPayeeButton;

    @FindBy(css = "div#alert_content")
    public WebElement messageOfPayeeCreated;

    @FindBy(css = "select#pc_currency")
    public WebElement currencyOptions;

    @FindBy(css = "input#pc_calculate_costs")
    public WebElement CalculateCostButton;

    @FindBy(css = "input#pc_amount")
    public WebElement AmountCurrency;

    @FindBy(css = "input#pc_inDollars_true")
    public WebElement radioUSDollar;

    @FindBy(css = "input#pc_inDollars_false")
    public WebElement radioSelectedCurrency;




}
