Feature: Check balance

  Scenario: A customer should be able to check its account balance
    Given Alma has 25 EUR in her account
    When she checks her balance
    Then should she see 25 EUR

  Scenario: A customer should be able to deposit
    Given Stina has 25 EUR in her account
    And she deposits 10 EUR
    When she checks her balance
    Then should she see 35 EUR

  Scenario: A customer should be able to withdraw funds
    Given Lena has 25 EUR in her account
    When she withdraws 10 EUR
    Then she should have 15 EUR in her account

  Scenario: A customer should not be able to withdraw more than their account holds
    Given Brita has 25 EUR in her account
    When she tries to withdraw 35 EUR she should be informed that she exceeds her funds
    And her balance should still be 25 EUR
