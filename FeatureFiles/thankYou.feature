Feature: validate ThankYou message

  @sanity @regression
  
  Scenario: Fill the form with correct input datas
    Given the user clicks on the For Corporates option
    And the user clicks on the health and wellness option
    When the user provides the correct data to the input fields except mailID
    Then the user should check the Schedule a demo button is enabled or not
    When the user provides the correct mailId and
    Then the user should click the schedule a demo button and
    Then the user should see the Thank You message displayed
