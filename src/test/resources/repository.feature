Feature: As a user I should be able create a repository on gitHub

  Scenario: User should be able create repository on gitHub
    Given I navigate to "https://github.com"
    When I click on "Sign in" link
    And I enter "gitHubUsername" to "Username or email address" field
    And I enter "gitHubPassword" to "Password" field
    And I click on "Sign in" button
    Then user successfully logged into the system