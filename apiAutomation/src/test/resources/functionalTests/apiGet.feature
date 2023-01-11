Feature: test

  Scenario Outline: test
    Given I call get on users for "<user>"
    Then I will be returned a status code "<expectedStatusCode>"
    And I will be returned an ID "<expectedID>"

    Examples:
      | user | expectedStatusCode | expectedID   |
      | 2    | 200                |  2 |
      | 3    | 200                |3|

