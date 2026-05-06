 Feature: categories functionality
description: user should be able to see the 3 categories
  @phonecategory
  Scenario: category of phone
   Given the user is on homepage
   When user clicks on the phone option in category
   Then user should see the phone product page
   
   @laptopcategory
   Scenario: category of laptops
   Given the user is on the home page
   When user clicks on laptop option in category
   Then user shoul d see the laptop product page
   
   @monitorcategory
   Scenario: category of monitors
   Given the user is on home page
   When user clicks on monitor option in category
   Then user should see the monitor product page
   
   
   