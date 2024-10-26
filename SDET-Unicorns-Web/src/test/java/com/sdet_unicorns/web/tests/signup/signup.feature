Feature: Signup

  Scenario Outline: SDET-U New Account Signup

    Given  open SDETUnicorns and click on user profile button in home page
    When   select register option from user profile menu in home page
#    And    enter username "<username>" in registration page
#    And    enter email "<email>" in registration page
#    And    enter password "<password>" in registration page
#    And    select gender "<gender>" in registration page
#    And    click on register button in registration page
#    Then   validate that user profile contains button logout

    Examples:
      | username | email | password | gender  |
      | username | email | password | gender  |



