Feature: Muhindhar_05.05.2026_Register to the tutorialsNinja site
Description: Registeration of TitorialsNinja site

  @ValidRegisteration
  Scenario: Register as a new user
    Given the user is on tutorialsninja site
    When user clicks on MyAccount link and Click Register link
	And  user enters valid credentials
	|First Name|Last Name|E-mail		  |Telephone |Password|Password confirm|
	|muhi	   |sv	     |muhi27@gmail.com|9809876542|demo1234|demo1234	 	   |
	Then user clicks on continue button