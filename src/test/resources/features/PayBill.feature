@wip
Feature: Paying a Bill
  Background:
    Given the user is on the login page
    And the user enters valid keys
    When the user navigates to Online Banking page
    And the user navigates to PayyBill page

  Scenario: the user checks the page title
    Then the page title is "Zero - Pay Bills"

  Scenario: User can pay a bill with valid amount and date
    When the user selects payee
    And the user selects Account
    And the user enters Amount in dollars "15"
    And the user selects date "2021-02-24"
    And the user enters a description
    And the user clicks pay
    Then the user see the message "The payment was successfully submitted."

    Scenario: user can not enter non-numeric amount and pay bill
      When the user selects payee
      And the user selects Account
      And the user enters Amount in dollars "ABCD"
      And the user selects date "2021-02-24"
      And the user enters a description
      And the user clicks pay
      Then the user cannot see the message "The payment was successfully submitted."


  Scenario: user can not  pay bill without selecting date
    When the user selects payee
    And the user selects Account
    And the user enters Amount in dollars "15"
    #And the user selects date "2021-02-24"
    And the user enters a description
    And the user clicks pay
    Then the user see the "date" error message  "Please fill out this field."


  Scenario: user can not  pay bill without entering amount
    When the user selects payee
    And the user selects Account
    #And the user enters Amount in dollars "15"
    And the user selects date "2021-02-24"
    And the user enters a description
    And the user clicks pay
    Then the user see the "amount" error message  "Please fill out this field."


  Scenario: user can not  enter alphabetic characters in date
    When the user selects payee
    And the user selects Account
    And the user enters Amount in dollars "15"
    And the user selects date "2021-AB-02"
    Then the user confirms alphabetic characters are not allowed in date field