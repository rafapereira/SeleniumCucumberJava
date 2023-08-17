#CreatedBy: rafael.pereira
#Date: 2023/07/25
@SmokeScenario
Feature: Edit table
  @SmokeTest
  Scenario Outline: Editing of customer table row by country
    Given Im on table page
    When I find a customer from <country>
    And click on edit button of the corresponding row
    And I edit customer informations
    Then the customer information changes for the new values

    Examples:
      | country |
      | USA     |
      | France  |
