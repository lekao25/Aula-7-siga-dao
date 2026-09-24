# Atividade Aula 7 — Refatoração do Sistema SIGA

## Diagnóstico do problema

Antes da refatoração, a classe `ServicoMatricula` possuía responsabilidades que deveriam estar separadas.

O método `matricular()` era responsável por validar as regras de negócio da matrícula e também por realizar o acesso aos dados por meio da classe `BancoSimulado`.

Essa organização causa problemas de manutenção, pois a classe `ServicoMatricula` fica diretamente dependente da forma como os dados são armazenados.

## Violação do princípio da responsabilidade única

A classe `ServicoMatricula` viola o princípio da responsabilidade única, também conhecido como SRP.

O método `matricular()` possui duas responsabilidades principais:

1. Validar as regras de negócio da matrícula, como verificar se a média do aluno é válida.
2. Salvar os dados do aluno no banco ou em outro mecanismo de persistência.

Essas responsabilidades deveriam estar separadas. A classe `ServicoMatricula` deve cuidar apenas das regras de negócio, enquanto outra classe deve ser responsável pelo armazenamento e pela recuperação dos dados.

A classe poderia precisar ser alterada por dois motivos diferentes:

- alteração nas regras de validação da média do aluno;
- alteração na forma como os dados são armazenados.

Isso demonstra que a classe possui mais de uma responsabilidade.

## Violação do princípio da inversão de dependência

A classe `ServicoMatricula` também viola o princípio da inversão de dependência, conhecido como DIP.

Atualmente, ela depende diretamente da classe concreta `BancoSimulado`. Dessa forma, o serviço fica preso a uma implementação específica de armazenamento.

Caso seja necessário trocar o `BancoSimulado` por um banco de dados real, um arquivo ou uma implementação em memória, a classe `ServicoMatricula` precisará ser modificada.

O ideal é que `ServicoMatricula` dependa de uma abstração, representada pela interface `AlunoDAO`.

Assim, diferentes implementações de persistência poderão ser utilizadas sem alterar as regras de negócio do serviço.

## Problemas identificados

Os principais problemas encontrados foram:

- mistura entre regras de negócio e acesso a dados;
- dependência direta da classe `BancoSimulado`;
- dificuldade para trocar a forma de armazenamento;
- maior dificuldade para realizar testes;
- possibilidade de alterações em uma responsabilidade afetarem outra.

## Solução proposta

Para corrigir esses problemas, será criada a interface `AlunoDAO`, contendo as operações de persistência dos alunos.

Também será criada a classe `AlunoDAOMemoria`, que implementará essa interface utilizando uma estrutura de dados em memória.

A classe `ServicoMatricula` receberá um objeto `AlunoDAO` pelo construtor. Dessa forma, ela poderá utilizar qualquer implementação da interface sem conhecer os detalhes de armazenamento.

Com essa refatoração:

- `ServicoMatricula` ficará responsável pelas regras de negócio;
- `AlunoDAO` representará as operações de acesso aos dados;
- `AlunoDAOMemoria` ficará responsável pelo armazenamento em memória;
- será possível trocar a implementação do DAO sem modificar o serviço.
