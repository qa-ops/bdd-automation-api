 # language: pt

 Funcionalidade: Gerenciamento de um usuario da PetSore

   Algum contexto de negócio
   História do Jira
   O que fizer sentido para o negócio

   Cenario: Cria um usuario na loja
     Quando eu faço um POST para /v3/user com os seguintes valores:
       | id         | 10              |
       | username   | rafael          |
       | firstName  | Rafael          |
       | lastName   | Lima            |
       | email      | rafael@email.com |
       | password   | 12345           |
       | phone      | 12345           |
       | userStatus | 1               |
     Então quando faço um GET para /v3/user, o usuário criado é retornado

   Cenario: Cria um usuario na loja usando docstring
     Quando eu faço um POST para /v3/user com a seguinte docstring:
      """json
      {
        "id": 10,
        "username": "theUser",
        "firstName": "John",
        "lastName": "James",
        "email": "john@email.com",
        "password": "12345",
        "phone": "12345",
        "userStatus": 1
      }
      """
     Então quando faço um GET para /v3/user, o usuário criado é retornado

   Cenario: Cria usuário na loja refletindo o negócio
     Quando crio um usuário
     Então o usuário é salvo no sistema