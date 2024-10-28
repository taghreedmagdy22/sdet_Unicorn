Feature:
  As a user
  I want to be able to add products to my cart
  so that I can proceed to checkout

  @SDET-U
  Scenario Outline: Login To My Account Successfully

    Given  user open SDETUnicorns and click on user profile button in home page
    When   select login option from user profile menu in home page
    And    enter email "<email>" and password "<password>" in login page
    And    click on login button in login page
    Then   validate that user profile contains button my account

    Examples:
      | email | password |
      | email | password |

  Scenario Outline: Filter Products To Chosen Category

    Given  user is on products page
    When   click on keyboard under categories list in products page
    And    click on apply button in products page
    Then   validate that filtered products are only the chosen category "<categoryName>"

    Examples:
      |categoryName|
      |categoryA   |


  Scenario Outline: Check product details
    When   click on product item "<productName>"
    Then   validate that product name "<productName>" and price are valid

    Examples:
      | productName     |
      | ProductAName    |



  Scenario Outline: Add one item to cart
    Given  cart is empty
    When   click on Add to cart
    Then   success message displayed for added item
    And    cart contains one "<count>" element
    Examples:
      | count |
      | 1     |



  Scenario Outline: Add extra item to cart
    Given  user is on products page
    When   click on laptop under categories list in products page
    And    click on apply button in products page
    And    click on product item "<productName>"
    And    click on Add to cart
    Then   two chosen products exist in cart
    And    total amount calculated correctly



    Examples:
     |productName |
     |ProductBName|

  Scenario Outline: Checkout
    When click on checkout button in cart page
    And  select country "<country>" and select region "<region>" in cart page
    And  enter first adress "<firstAddress>" and postal code "<postalCode>" in cart page
    And  enter phone number "<phone>" in cart page
    And  mark cash on delivery checkbox in cart page
    And  click on confirm button in cart page
    And  click on order details
    Then validate display of correct address "<firstAddress>" and amount "<amount>"

    Examples:
      |country |region |firstAddress|postalCode|phone|amount|
      |country | region|address1    |zipCode   |phone|amount|
