
Feature: Add a product to Cart

  Scenario Outline: Add a product to cart and Verify it is added in cart
    Given User is at Website homepage
    When User select product with <productName> and click on to cart button
    Then Product with <productName> is added in cart panel
 Examples: 
      | productName  | 
      | Tomato 			 |     
      | Apple				 | 
