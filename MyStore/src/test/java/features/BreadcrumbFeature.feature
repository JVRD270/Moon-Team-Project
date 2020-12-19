Feature: Utilizing breadcrumbs

	Background: User starts on home page
		Given user goes to the home page

  Scenario: User goes to summer dress page and clicks home breadcrumb
    When user goes to the dresses page
    And user clicks on the summer dress item
    And user clicks the home breadcrumb
    Then user is on the home page
