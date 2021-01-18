Feature: Managing the orders

  @DeleteExtraPets
  Scenario: Client creates an order
    Given I have a pet available
    When I order that pet
    Then the order is approved