Feature: Validate the registration on Step 1

  Scenario: TC_Registration on step 1 success
    Given I navigate to UTest Sign up page
    When I complete to the form in Step 1
    Then I should able to submit form successfully

Scenario: TC_Validation error message when user fill invalid email
  Given I navigate to UTest Sign up page
  When I enter invalid email
  Then the error message displays with text "Enter valid email"
