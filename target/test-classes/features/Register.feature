Feature: Register Account Functionality

Scenario: Verify Registering Account with Mandatory fields
Given User navigate to Register Account Page
When User enter below fields
|firstName|  Pranav|
|lastName|Gupta|
|telephone|8998191299|
|password|12345|
And user select privacy policy field
And User clicks on Contiue button
Then User should get logged in
And User should be taken to account success page
And Proper details should be displayed on the Account Success page
When User clicks on continue button on Account success page 
Then USer should be navigate to My Account Page

Scenario: Verify Registering Account by filling all the fields
Given User navigate to Register Account Page
When User enter below fields
|firstName|Pranav|
|lastName|Gupta|
|telephone|8998191299|
|password|12345|
And user select Yes option for Newsletter
And user select privacy policy field
And User clicks on Contiue button
Then User should get logged in
And User clicks on continue button on Account success page