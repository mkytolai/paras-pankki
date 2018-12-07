Feature: Check balance

    Scenario: A customer should be able to check its account balance
        Given "Alma" has 25 EUR in her account
        When "Alma" checks her balance
        Then should she see 25 EUR