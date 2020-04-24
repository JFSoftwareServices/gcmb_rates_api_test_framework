@future
Feature: Get future rates

  @TC_015
  Scenario: Actor calls Exchange rates API to get future foreign exchange reference rates.
    When an actor requests for future rates
    Then the response status code is 200
    And the response date is the current date