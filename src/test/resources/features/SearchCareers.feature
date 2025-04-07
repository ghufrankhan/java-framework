Feature: Search the LexisNexis Careers page

# Expected to pass
  Scenario: Search for an Automation Tester role and see results
    Given the user is on the LexisNexis homepage
    And I click on the Accept All Cookies button if the banner is present
    When I navigate to the Careers page
    And a new tab is opened
    Then the page title should be 'Careers'
    When I click on the Search jobs button
    Then the page title should be 'Search Jobs'
    When I search for 'automation tester'
    Then I should see more than or equal to '1' results

# Expected to fail
  Scenario: Search for an invalid role and see no results
    Given the user is on the LexisNexis homepage
    And I click on the Accept All Cookies button if the banner is present
    When I navigate to the Careers page
    And a new tab is opened
    Then the page title should be 'Careers'
    When I click on the Search jobs button
    Then the page title should be 'Search Jobs'
    When I search for 'abcdx'
    Then I should see more than or equal to '1' results