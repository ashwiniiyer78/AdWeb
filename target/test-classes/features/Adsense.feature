
Feature: Make sure Ad sense is visible

@RegTest
Scenario:  User visits betbuy page
When   User search for "headphones"
Then Check if the PLP Page shows the Adsense
And  close the browser

