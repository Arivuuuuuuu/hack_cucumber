Feature: validate Schedule a demo button by providing Invalid contact number

  @sanity @regression
  Scenario: Fill the form with Invalid contact number
    Given the user clicks on the For Corporates option
    And the user clicks on the health and wellness option
    When the user provides the invalid contact number
    Then the user should not be able to click the schedule a demo button
