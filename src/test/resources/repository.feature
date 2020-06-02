Feature: Repository feature
  As a user I should be able work with repository on gitHub

  Scenario: User should be able create repository on gitHub
    Given I navigate to "https://github.com"
    When I click on "Sign in" link
    And I enter "gitHubUsername" to "Username or email address" field
    And I enter "gitHubPassword" to "Password" field
    And I click on "Sign in" button
    Then user successfully logged into the system
    When I create new repository with name "demo-repo"
    Then repository "demo-repo" created successfully

  Scenario: User should be able delete repository from gitHub service
    Given I delete repository with name "demo-repo"
    And I navigate to "https://github.com"
    When I click on "Sign in" link
    And I enter "gitHubUsername" to "Username or email address" field
    And I enter "gitHubPassword" to "Password" field
    And I click on "Sign in" button
    Then user successfully logged into the system
    And repository "demo-repo" deleted successfully
