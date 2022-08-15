Feature: 

	#trial2
	@MENT-36
	Scenario: connect Jira to Xray
		            Given the user logs in as "hr"
				    And the user navigates to "Services" page
				    And the user clicks training
				    When the user goes to "Profile"
				    And the user fills the form
				    When the user clicks save profile
				    Then the user sees the profile saved