
@suite
Feature: Sample test scenario
 This is a sample test scenario for jfk

  @scenario
  Scenario: Search covid 19 in Malaysia
    Given user open Google webpage
    And search "covid 19 in Malaysia"
    Then verify Top Stories section is available
   #Cannot find 'common questions section' so I use 'Health Information' instead
    And verify Health Information section is available
    When MOH link is clicked
    Then verify route to MOH page

  