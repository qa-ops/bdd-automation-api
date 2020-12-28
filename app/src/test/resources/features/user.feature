Feature: Managing a user in the PetStore

  Any business context
  Jira stories
  Whatever makes sense in the business area

  Scenario: Create a user in the petstore
    When I do a POST to /v3/user with the following values:
      | id         | 10               |
      | username   | rafael           |
      | firstName  | Rafael           |
      | lastName   | Lima             |
      | email      | rafael@email.com |
      | password   | 12345            |
      | phone      | 54321            |
      | userStatus | 1                |
    Then I receive the created user when I do a GET to /v3/user/rafael

  Scenario: Create a user in the petstore with docstring
    When I do a POST to /v3/user with the docstring:
#    """json
#        {
#          "id": 11,
#          "username": "theUser",
#          "firstName": "John",
#          "lastName": "James",
#          "email": "john@email.com",
#          "password": "12345",
#          "phone": "12345",
#          "userStatus": 1
#        }
#    """
    Then I receive the created user when I do a GET to /v3/user/theUser



  Scenario: Create a user in the petstore in a business way
    When I create a user
    Then the created user was stored