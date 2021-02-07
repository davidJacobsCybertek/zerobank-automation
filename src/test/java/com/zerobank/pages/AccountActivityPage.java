package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

public class AccountActivityPage {

    public AccountActivityPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "select#aa_accountId")
    public WebElement accounts;

    @FindBy(xpath = "//div[@id='all_transactions_for_account']//th")
    public List<WebElement> accountTableColumns;

    @FindBy(css = "#aa_fromDate")
    public WebElement fromDate;

    @FindBy(css = "#aa_toDate")
    public WebElement toDate;

    @FindBy(css = "#aa_description")
    public WebElement description;

    @FindBy(css = "#aa_type")
    public WebElement typeOptions;

    @FindBy(css = "a[href='#ui-tabs-2']")
    public WebElement findTrasactionsLink;

    @FindBy(css = "button.btn.btn-primary")
    public WebElement findButton;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']//tbody/tr")
    public List<WebElement> tableRows;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']//tbody/tr/td")
    public List<WebElement> tableCells;

    public int[] dateToIntArrayConverter(String date) {
        String[] dataArrayString = date.split("-");
        int[] dateArray = {Integer.parseInt(dataArrayString[0]),
                Integer.parseInt(dataArrayString[1]),
                Integer.parseInt(dataArrayString[2])};
        return dateArray;
    }

    public List<String> findTransactionDates(){

        int numberOfTransactions = tableRows.size();
        //System.out.println("numberOfTransactions = " + numberOfTransactions);
        List<String> allCells = BrowserUtils.getElementsText(tableCells);
        //System.out.println(allCells.toString());
        List<String> transactionDates = new ArrayList<>();
        for (int i = 0; i < numberOfTransactions; i++) {
            transactionDates.add(allCells.get((4 * i)));
        }
        //System.out.println(transactionDates.toString());
        return transactionDates;
    }
    public List<String> findTransactionDescriptions(){

        int numberOfTransactions = tableRows.size();
        //System.out.println("numberOfTransactions = " + numberOfTransactions);
        List<String> allCells = BrowserUtils.getElementsText(tableCells);
        //System.out.println(allCells.toString());
        List<String> transactionDescriptions = new ArrayList<>();
        for (int i = 0; i < numberOfTransactions; i++) {
            transactionDescriptions.add(allCells.get(((4 * i)+1)));
        }
        System.out.println(transactionDescriptions.toString());
        return transactionDescriptions;
    }

    public List<String> findAmounts(String account){
        BrowserUtils.waitFor(1);
        int numberOfTransactions = tableRows.size();
        //System.out.println("numberOfTransactions = " + numberOfTransactions);
        List<String> allCells = BrowserUtils.getElementsText(tableCells);
        //System.out.println(allCells.toString());
        List<String> amounts = new ArrayList<>();
        String cellAmount="";
        for (int i = 0; i < numberOfTransactions; i++) {
            if(account.equals("Deposit")){
            cellAmount=allCells.get((4 * i)+2);
                if (!cellAmount.isEmpty())
                amounts.add(cellAmount);
        }else if (account.equals("Withdrawal")){
                cellAmount=allCells.get((4 * i)+3);
                if (!cellAmount.isEmpty())
                amounts.add(cellAmount);;
            }
        }
        System.out.println(account+" cells "+amounts.toString());
        System.out.println(account+" cells size = "+amounts.size());
        return amounts;
    }

}