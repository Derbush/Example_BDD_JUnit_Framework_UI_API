@api
Feature: Create a new user in the petstore

  Scenario Outline: Create a new user and verify the record wqs created

    Given Create a new User using "<id>", "<username>", "<firstName>", "<lastName>", "<email>", "<password>", "<phone>", "<userStatus>"
    When POST the below sample json to the createWithArray endpoint
    Then GET the information calling GET service and "<username>" param
    And Verify the record is retrieved successfully with all the details
    Then Delete the "<username>"
    Examples:
      | id    | username     | firstName | lastName | email            | password | phone   | userStatus |
      | 43433 | 323243431qw  | RRRR      | LLL      | we@gmail.com     | 23dwewe  | 2324433 | 0          |
      | 43435 | 323243431uy  | Jon       | Milnes   | milnes@gmail.com | 24dwiuy  | 232400  | 3          |
      | 34098 | 0998765446gr | Harry     | Sen      | hsen@gmail.com   | 23dwewe  | 9876543 | 2          |