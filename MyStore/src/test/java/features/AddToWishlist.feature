Feature: Add to Wishlist

  Scenario: Adding Printed Dress to the wishlist
    Given user is logged into their account
    When user opens the printed dress
    And user click add to wishlist
    Then user will see the printed dress in the wishlist

