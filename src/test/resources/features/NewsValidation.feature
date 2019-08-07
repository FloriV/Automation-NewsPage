# Before running tests add ChromeDriver to path system environment variable
Feature: Social Network comment feature testing

  Scenario Outline: Confirm latest news is valid
    Given I launch News | The Guardian
    And I take the newest article post
    When I search <source> for the article title
    Then I should receive some related articles
    And at least 2 different sources should be found

    Examples:
      | source                 |
      | https://www.google.com |
      | https://www.bing.com   |
