@smoke
Feature: Search by keyword

  Scenario: Searching for a term
    Given Dinesh is searching for government awards
    When he looks up "Mobile App" keyword
    Then he should see all "Mobile App" related awards


