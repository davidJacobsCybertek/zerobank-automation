@reg
Feature: Login
Background:
  Given the user is on the login page

  Scenario: Authorised used can log in
    When the user enters valid keys
    Then the user should be able to login


  Scenario: unAuthorised user cannot Login
    When the user enters invalid keys like "user10" "wrongpass"
    Then error message occurs

    Scenario: User cannot log in without username or password
      When User does nor enter valid keys but click SignIn
      Then error message occurs





