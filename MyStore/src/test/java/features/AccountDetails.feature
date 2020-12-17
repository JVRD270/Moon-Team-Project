Feature: User should be able to change personal account details
	Scenario: Change account settings
		Given user views account details
		When user enters "Yuri" into First Name
		And user enters "Nader" into Last Name
		And user enters "butts" into Current Password
		And clicks save button
		Then response given "Your personal information has been successfully updated."
		
	Scenario Outline: Change account settings scenario outline
		Given user views account details
		When user enters "<firstname>" into First Name
		And user enters  "<lastname>" into Last Name
		And user enters "<password>" into Current Password
		And clicks save button
		Then response given "<response>"