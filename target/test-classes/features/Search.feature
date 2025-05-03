Feature: Verify Search Functionality

Scenario:Verify searching with existing product
Given User in on the home page
When User enter exiting product into search box field
And User clicks on Search button
Then Product Should be displayed


Scenario:Verify searching with no existing product
Given User in on the home page
When User enter no exiting product into search box field
And User clicks on Search button
Then Product message Should be displayed

