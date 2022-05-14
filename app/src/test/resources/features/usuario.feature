 # language: pt
 Funcionalidade: Gerenciamento de um usuario da PetSore

   Algum contexto de negócio
   História do Jira
   O que fizer sentido para o negócio

   @deleteAllUsers @sanity
  Cenario: Cria usuário na loja refletindo o negócio
     Quando crio um usuário
     Então o usuário é salvo no sistema