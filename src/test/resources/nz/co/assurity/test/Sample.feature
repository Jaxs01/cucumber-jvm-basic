Feature: Purchase Tea
  As a Customer I should be able to provide my details inorder to purchase tea.
  As a Customer I need to purchase different tea types.
#  UseCase 2
#  UseCase 3

  Background:
    Given Precondition one
    And Precondition two

  Scenario: Navigate to Home Page
    When I open Passion Tea URL
    Then I should land at the Home page

  Scenario: Select a tea type
    Given I open the tea Categories Page
    When I click on the Red Tea checkout link
    Then I should navigate to Checkout page

  Scenario: Checkout a tea type
    Given I open the tea Categories Page
    When I click on the Red Tea checkout link
    And I enter name "UserOne" in the Name field
    And I enter address "AddressOne" in the Address field
    And I enter the email "test@assurity.co.nz" in the email field.
    And I click submit Button
    Then I should successfully navigate to Menu page