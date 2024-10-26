Feature:
  As a user
  I want to be able to login successfully and
  filter products based on desired category

  Scenario Outline: Login To My Account Successfully

    Given  open SDETUnicorns and click on user profile button in home page
    When   select login option from user profile menu in home page
    And    enter email "<email>" and password "<password>" in login page
    And    click on login button in login page
    Then   validate that user profile contains button my account

    Examples:
      | email | password |
      | email | password |

  Scenario Outline: Filter Products To Chosen Category

    Given  user is on products page
    When   click on keyboards under categories list in products page
    And    click on apply button in products page
    Then   validate that filtered products are only the chosen category "<chosenCategory>"

    Examples:
      | chosenCategory |
      | Keyboard       |



