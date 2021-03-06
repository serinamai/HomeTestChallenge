Feature: Validate the registration on Step 1

  Scenario: TC_Registration on step 1 success
    Given I navigate to UTest Sign up page
    When I complete to the form in Step 1
    Then I should able to submit form successfully

