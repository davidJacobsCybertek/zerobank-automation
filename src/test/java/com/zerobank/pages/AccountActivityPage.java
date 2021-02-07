package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.WeakHashMap;

public class AccountActivityPage {

    public AccountActivityPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "select#aa_accountId")
    public WebElement accounts;

    @FindBy(xpath = "//div[@id='all_transactions_for_account']//th")
    public List<WebElement> accountTableColumns;

}
