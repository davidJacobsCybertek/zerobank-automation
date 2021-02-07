
Feature: Account Activity
  Background:
    Given the user is on the login page
    And the user enters valid keys
    When the user navigates to Online Banking page
    And the user navigates to Account Activity page


  Scenario: User see the accout activity title
   Then the user see the page title is "Zero - Account Activity"



    Scenario: User see the selected account is savings
      Then the savings account is selected

    Scenario: User see all the account options
      Then The accounts options should be like
      |Savings|
      |Checking|
      |Loan    |
      |Credit Card|
      |Brokerage|


  Scenario: Transaction table columns
    Then the transaction table column names are like following
    |Date|
  |Description|
  |Deposit    |
  |Withdrawal |