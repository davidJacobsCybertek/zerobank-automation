@color
Feature: getting color with selenium

  Background:
    Given the user is on the login page
    And the user enters valid keys
#    When the user navigates to Online Banking page
#    And the user navigates to Account Activity page

  Scenario: validate the color is the same with given
    Then the color of the botton is  "#0098D8"