Feature: validate Schedule a demo button by providing invalid name

  @sanity @regression
  Scenario: Fill the form with Invalid Name
    Given the user clicks on the For Corporates option
    And the user clicks on the health and wellness option
    When the user provides the Invalid name
    Then the user should not be able to click the schedule a demo button
