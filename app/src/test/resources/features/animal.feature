# language: pt
Funcionalidade: Gerenciamento de um pet da PetSore

  Cenario: Lista somente pets disponíveis para a venda
    Dado que eu possua pets available
    Quando eu pesquiso por todos os pets available
    Então eu recebo a lista de pets disponíveis