Feature: Working with search on site https://www.sputnik.ru/

  Scenario: Make a successful request on site
    Given Open a search page on sputnik.ru
    When  User type a "Спутник"
    And   Press Enter
    Then  The answer page contains Спутник