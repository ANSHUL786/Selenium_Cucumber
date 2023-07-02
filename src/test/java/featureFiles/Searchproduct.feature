Feature: Verify unified search result across all search fields

Scenario: Verify the Home Page Search Functionality
Given User is at Website homepage
When User search with partial product name "tom"
Then "Tomato" should be shown among all results
    
Scenario Outline: Verify the Offer Page Search Functionality
Given User is at Offer Page
When User search with partial product name <partialName> on offer page
Then <productName> should be shown in offer list
Examples:
|productName		| partialName	|
|Tomato					| tom					|
|Rice						|	ric					|