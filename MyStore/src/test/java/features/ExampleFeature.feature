Feature: Searching Google should return the name of query

  Scenario: Google search with scenario
    Given user launches Google webapp
    When user searches for a "LambdaTest"
    And click on search button
    Then results retrieved should contain the "LambdaTest" used

  Scenario Outline: Searching google using scenario outline and examples
    Given user launches Google webapp
    When user searches for a "<query>"
    And click on search button
    Then results retrieved should contain the "<query>" used
    
    Examples:
    | query |
    | anotherTest |