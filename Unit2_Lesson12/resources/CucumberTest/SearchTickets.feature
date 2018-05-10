Feature: SearchTickets

  Scenario: Finding all available tickets from A to B
    Given Open a search page at http://blazedemo.com/index.php
    When I choose a departure City
    And  I choose a destination City
    And  Click at Find Flights
    Then The page title contains MyCities


