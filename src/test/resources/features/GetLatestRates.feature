@latest
Feature: Get latest date rates

  @TC_001
  Scenario: Actor calls Exchange rates API to get the latest foreign exchange reference rates.
    When an actor requests for the latest rates
    Then the response status code is 200
    And the default response for the latest rates should be in the correct format
    And the response base currency is "EUR"
    And the response date is in a valid format

  @TC_002
  Scenario: Actor calls Exchange rates API to get the latest specific foreign exchange reference rates.
    When an actor requests the latest rates for:
      | USD | GBP |
    Then the response status code is 200
    And the default response for the latest rates should be in the correct format for:
      | USD | GBP |
    And the response base currency is "EUR"
    And the response date is in a valid format

  @TC_003
  Scenario: Actor calls Exchange rates API to get the latest foreign exchange reference rates against a non default base currency.
    When an actor requests the latest rates for base currency "USD"
    Then the response status code is 200
    And the response for a base currency of "USD" should be in the correct format
    And the response base currency is "USD"
    And the response date is in a valid format

  @TC_004
  Scenario: Actor calls Exchange rates API to get the latest specific foreign exchange reference rates against a non default base currency.
    When an actor requests the latest rates for base currency "USD" for:
      | GBP |
    Then the response status code is 200