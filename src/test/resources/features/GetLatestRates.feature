@latest
Feature: Get latest date rates

  @TC_001
  Scenario: Actor calls Exchange rates API to get the latest foreign exchange reference rates.
    When an actor requests for the latest rates
    Then the response status code is 200
    And the default response for the latest rates should be in the correct format
    And the response base currency is "EUR"
    And the response date is in a valid format