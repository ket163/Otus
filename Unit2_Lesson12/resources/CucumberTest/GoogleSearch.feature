Feature: GoogleSearch

  Scenario: Finding some words
    Given Open a search page at ya.ru
    When I search for "Cars"
    Then The page title contains "Cars"


