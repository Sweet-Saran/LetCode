
Feature: CheapAir Automation

  Scenario: Validate the booking flight ticket 
    Given Launch the application 
    And Verify the homepage logo
    When Click on the Round trip dropdown and select the one-way
    And Select the from and to cities
    And Select the start and end date with timing 
    Then Click the search flights button
    And Validate the resulted flight details



  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
