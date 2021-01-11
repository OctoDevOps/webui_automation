
Feature: Search by keyword
@smoke @regression
  Scenario: Searching for a term 'Mobile App'
    Given Dinesh is searching for government awards
    When he looks up "Mobile App" keyword
    Then he should see all "Mobile App" related awards

Scenario: Searching for a term 'Environmental'
    Given Dinesh is searching for government awards
    When he looks up "Environmental" keyword
    Then he should see all "Environmental" related awards

@regression
  Scenario: Searching for a term with a Filter option
    Given Dinesh is searching for government awards
    When he looks up "Mobile App" keyword and selected "Contract Opportunities" option
    Then he should see all "Mobile App" related awards


