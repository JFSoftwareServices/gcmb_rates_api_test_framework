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

  @TC_007
  Scenario: Actor calls Exchange rates API to get historical foreign exchange reference
    When an actor requests historical rates for "2010-01-12" with base currency "USD"
    Then the response status code is 200
    And the response for a base currency of "USD" for historical rates for "2010-01-12" for all currencies should be in the correct format

  @TC_008
  Scenario: Actor calls Exchange rates API to get specific historical foreign exchange reference rates against a non default base currency.
    When an actor requests historical rates for "2010-01-12" with base currency "USD" for currencies:
      | GBP |
    Then the response status code is 200
    And the response for a base currency of "USD" for historical rates for "2010-01-12" with currencies "GBP" should be in the correct format

  @TC_010
  Scenario:  Actor calls Exchange rates API to get historical foreign exchange reference rates, for an unsupported base currency.
    When an actor requests historical rates for "2010-01-12" with base currency "UDD"
    Then the response status code is 400
    And the response is:
    """
    {"error":"Base 'UDD' is not supported."}
    """

  @TC_011
  Scenario: Actor calls Exchange rates API to get historical foreign exchange reference rates, for an unsupported currency.
    When an actor requests historical rates for "2010-01-12" with base currency "USD" for currencies:
      | GDP |
    Then the response status code is 400
    And the response is:
    """
    {"error":"Symbols 'GDP' are invalid for date 2010-01-12."}
    """

  @TC_013
  Scenario: Actor calls Exchange rates API to get historical rates with a date that is too old.
    When an actor requests historical rates for "1999-01-03"
    Then the response status code is 400
    And the response is:
    """
    {"error":"There is no data for dates older then 1999-01-04."}
    """