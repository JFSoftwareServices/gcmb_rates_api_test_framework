@historical
Feature: Get historical rates

  @TC_005
  Scenario: Actor calls Exchange rates API to get historical foreign exchange reference rates.
    When an actor requests historical rates for "2010-01-12"
    Then the response status code is 200
    And the default response for the historical rates for "2010-01-12" should be in the correct format

  @TC_006
  Scenario: Actor calls Exchange rates API to get specific historical foreign exchange reference rates.
    When an actor requests historical rates for "2010-01-12" for currencies:
      | USD | GBP |
    Then the response status code is 200
    And the default response for the historical rates for "2010-01-12" with currencies "USD,GBP" should be in the correct format