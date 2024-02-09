Feature: Validate Go Shopping Page

  Background: For all senarious user is on the main page
    Given User in on the main page

  Scenario: Validate text in the modules of the first carousel
  When User clicks Go Shopping module
  Then Verify first carousel has "7" images
  And Verify text for the first module
    | Home essentials under $10   |
    | Best selling home textiles  |
    | Our lowest price storage    |
    | Our lowest price home décor |
    | New furniture               |
    | New home textiles           |
    | Best selling furniture      |

  Scenario: 2 Validate text in the modules of the first carousel
    When User clicks Go Shopping module
    Then Verify first carousel has "7" images
    And Verify text for the first module
      | Home essentials under $10   |
      | Best selling home textiles  |
      | Our lowest price storage    |
      | Our lowest price home décor |
      | New furniture               |
      | New home textiles           |
      | Best selling furniture      |
