Feature: Managing a user in the PetStore

  Any business context
  Jira stories
  Whatever makes sense in the business area

  @deleteAllUsers @sanity
  Scenario: Create a user in the petstore in a business way
    When I create a user
    Then the created user was stored