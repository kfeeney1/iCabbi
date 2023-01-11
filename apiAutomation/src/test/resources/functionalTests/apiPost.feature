Feature: test

  Scenario Outline: test
    Given I create a user name "<name>" and Job "<job>"
    Then I will be returned a status code "<expectedStatusCode>"
    And I will be returned a name "<name>"
    And I will be returned a job "<job>"


    Examples:
      | name   | job    | expectedStatusCode |
      | Kev    | Tester | 201                |
      | Declan | Boss   | 201                |

