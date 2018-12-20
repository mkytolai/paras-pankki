Feature: Check balance

  Scenario: A customer should be able to check its account balance
    Given Alma has 25 EUR in her account
    When she checks her balance
    Then should she see 25 EUR

  Scenario: A customer should be able to deposit
    Given Alma has 25 EUR in her account
    And Alma deposits 10 EUR
    When she checks her balance
    Then should she see 35 EUR