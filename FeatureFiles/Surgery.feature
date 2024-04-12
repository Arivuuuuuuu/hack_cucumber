Feature: user selects the surgeries list

  @sanity @regression
  
  Scenario: Successfully printing the surgery list
    When the user clicks on the surgeries option  
    Then the user should get the surgeries list
