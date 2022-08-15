@reg
Feature: Account Summary
Background:
  Given the user is on the login page
  And the user enters valid keys
  When the user navigates to Online Banking page
  And the user navigates to Account Summary page

  Scenario: User can see the page title
    Then the page title is "Zero - Account Summary"
  @david
  Scenario: User can see various Account Names
    Then the page should have following account types
    |Cash Accounts|
    |Investment Accounts|
    |Credit Accounts    |
    |Loan Accounts      |

  Scenario: User see the credit account columns
    Then the credit account colums are like following
    |Account|
    |Credit Card|
    |Balance    |