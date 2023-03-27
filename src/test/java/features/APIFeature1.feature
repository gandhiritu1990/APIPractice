Feature: Demo feature 1

  Scenario: Verify Place is added sucessfully
    Given API AddPlace request
    When user calls AddPlace API
    Then API call got success status code
