Feature: Verify login functionality

	Scenario: Verify login with valid crendentials
		 Given User navigate to login page
		 When  User enter valid email id and valid password into the fields
		 And Clicks on Login button
		 Then User should navigate to Account success page
		 
		 
		 
		 Scenario: Verify login with Invalid crendentials
		 Given User navigate to login page
		 When  User enter Invalid email id and Invalid password into the fields
		 And Clicks on Login button
		 Then User should not logged In
		 And User should get a warning message
		 
