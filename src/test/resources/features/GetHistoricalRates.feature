@historical
Feature: Get historical rates

  @TC_005
  Scenario: Actor calls Exchange rates API to get historical foreign exchange reference rates.
    When an actor requests historical rates for "2010-01-12"