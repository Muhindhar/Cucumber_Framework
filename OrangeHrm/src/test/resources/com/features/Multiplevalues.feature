 Feature: Login to orange Hrm

  @Multiple_Invalidcred
  Scenario: login with invalid values
    Given user is on HrmLogin Page
    Then user enters the invalid credentials and login will be unsuccessful with cus
      | username | password | errormessage        |
      | Admin    | admin12  | Invalid credentials |
      |          | admin123 | Required            |
      | Admin    |          | Required            |
