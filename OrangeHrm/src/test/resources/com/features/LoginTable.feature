Feature: Muhindhar_05.05.2026_Loginof scenario outline
Description: Logging in to orange hrm

  @ValidCredentials
  Scenario Outline: Login with valid credentials
    Given the user is on home page
    When user enters valid credentials
      | Admin | admin12 |
    And user clicks Login button
    Then user should be able to see an homepage
