Feature: Purchase Two Products

  Scenario Outline: Login To My Account Successfully

    Given  open SDETUnicorns and click on user profile button in home page
    When   select login option from user profile menu in home page
    And    enter email "<email>" and password "<password>" in login page
    And    click on login button in login page
    Then   validate that user profile contains button my account

    Examples:
      | email | password |
      | email | password |



