
Feature: Search by keyword
@smoke @regression
  Scenario: Searching for a term 'Environmental'
    Given Dinesh is searching for government awards
    When he looks up "Environmental" keyword
    Then he should see all "Environmental" related awards

@regression
  Scenario: Searching for a term with a Filter option
    Given Dinesh is searching for government awards
    When he looks up "Mobile" keyword and selected "Contract Opportunities" option
    Then he should see all "Mobile" related awards


