
Feature: Search by keyword
@smoke @regression
  Scenario: Searching for a term
    Given Dinesh is searching for government awards
    When he looks up "Mobile App" keyword
    Then he should see all "Mobile App" related awards

@regression
  Scenario: Searching for a term with a Filter option
    Given Dinesh is searching for government awards
    When he looks up "Mobile App" keyword and selected "Contract Opportunities" option
    Then he should see all "Mobile App" related awards


