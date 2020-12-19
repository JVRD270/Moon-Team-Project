#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template


################################## Everytime test is ran we need to change e-mail addresses 
################################## in csv file

@tag
Feature: Can register multiple
  I want to use this template for my feature file

  @tag1
 Scenario: want to register users in csv file
    Given I want to register multiple clients from a csv file to my store
    When I navigate to register page
    And submit required data for multiple users
    Then I verify each user already has their email registered

    