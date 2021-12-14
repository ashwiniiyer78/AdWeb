Feature: Sponsored Ad Element size check

  @RegTest
  Scenario: When user is on BBY Home page
    Given User is on betbuy page
    When User searches "blender"
    Then sponsored ad is displayed width "1160" and height "257"
    And close web page


