
Feature: Fetch & display the first five Doctors details
  @sanity @regression
  Scenario: Search Doctors for any city and apply filters
    Given user enters city as "<city>"
    And the user selects the speciality
    When user applies the filter
    Then the user should able to get the doctors list
    Examples: 
         |city|
         |Mumbai|
