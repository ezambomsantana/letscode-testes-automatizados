# Projeto

Desenvolver uma aplicação para o gereciamento de uma locadora de veículos. Devem existir duas classes, a Veiculo e a Aluguel. A classe Veiculo deve ter os atributos modelo, placa e disponivel.

A classe Aluguel deve ter os atributos dataEmprestimo, dataDevolucao e o veiculo alugado.

A aplicação deverá ter as seguintes operações:

- Cadastro de veículo
- Listagem de veículo
- Cadastro de Aluguel
- Listagem dos Alugueis
- Finalização do Aluguel (Devolução do veículo)

O cadastro do aluguel deve verificar se o carro que está sendo alugado existe, e se ele está disponível ou não. Se não existir ou não estiver disponível, deve ser retornado um erro para o usuário.

A data do emprestimo é sempre a data atual, e a dataDevelocao deve ser a dataEmprestimo + 7 dias.

Todos os métodos das classes de serviço devem ter pelo menos um teste unitário.

Poderá ser desenvolvida uma aplicação diretamente no console, ou implementar uma aplicação usando o Spring Boot (preferencialmente).
