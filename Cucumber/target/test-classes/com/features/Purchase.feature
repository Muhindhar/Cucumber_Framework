 Feature: purchasing of the product
description: The user is buying the product

  @addingproducttocart
  Scenario: Buying samsung galaxy s6
    Given the user is on home page
    When user selects the samsung galaxy s6 mobile
    And the user should see the description page of particular product
    And user should click the add to cart button
    Then the user should see the popup Product added.

    @cartpage
    Scenario: payment of selected prodcut
    Given the user is on home page
    When user clicks on cart button
    And user should be able to see the correct product chosen by user
    Then user clicks on the place order button
    
    @purchase
    Scenario: purchasing
    Given the user is on cart page
    When  user enters the name as "Muhindhar"
    And user enters country as "india"
    And user enters city as "chennai"
    And user enters creditcard number as "123456789012"
    And user enters month as "01"
    And user enters year as "2026"
    
    