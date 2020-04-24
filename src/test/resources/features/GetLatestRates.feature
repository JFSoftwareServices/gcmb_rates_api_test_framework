@latest
Feature: Get latest date rates

  @TC_001
  Scenario: Actor calls Exchange rates API to get the latest foreign exchange reference rates.
    When an actor requests for the latest rates
    Then the response status code is 200