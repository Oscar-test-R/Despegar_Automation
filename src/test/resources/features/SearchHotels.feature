Feature: Search Hotels in Despegar
 Scenario Outline: Search Hotels completed the inputs of city, dates and number of persons in Despegar

    Given Type the <city> in the textbox
    And Select the date check in and check out
    And Select the number of persons
    When Selects the Search button
    Then The results should shown

    Examples: |city|
              |cali|

  Scenario: Validate the search result

    Given Type the <city> in the textbox
    And Select the date check in and check out
    And Select the number of persons
    When Selects the Search button
    Then The results should shown