Feature: Manage a pet in the PetSore

  Scenario: List only available pets for sale
    Given that I have pets available
    When I search for all pets available
    Then I receive a list of pets available
#    Unecessary step, done for the sake of learning
    And I receive another list of pets available