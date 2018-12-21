Feature: Check balance

  Scenario: A customer should be able to check its account balance
    Given Alma has 25 EUR in her account
    When Alma checks her balance
    Then should she see 25 EUR

  Scenario: A customer should be able to deposit
    Given Stina has 25 EUR in her account
    And Stina deposits 10 EUR
    When Stina checks her balance
    Then should she see 35 EUR