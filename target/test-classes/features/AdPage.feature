Feature: Sponsored Ad Element size check

  @RegTest
  Scenario: When user is on BBY Home page
    Given User is on betbuy page
    When User searches "blender"
    Then sponsored ad is displayed width "1160" and height "257"
    And close the web page

@SanityTest
  Scenario: When user is on BBY Home page
    Given  user is on refigerators page
    Then Thoughts on this ad is visible
    And User able to give a survey
    And close web page

