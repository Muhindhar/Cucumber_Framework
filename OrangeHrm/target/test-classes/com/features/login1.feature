Feature: Muhindhar_05.05.2026_Loginof scenario outline
Description: Logging in to orange hrm

  @InvalidCredentials
  Scenario Outline: Login with invalid credentials
    Given the user is on home page
    When user enters username as "<username>" and password as "<password>"
    And user clicks Login button
    Then user should be able to see an "<errormessage>"

    Examples:
      | username | password | errormessage        |
      | Admin    | admin12  | Invalid credentials |
      |          | admin123 | Required            |
      | Admin    |          | Required            |
