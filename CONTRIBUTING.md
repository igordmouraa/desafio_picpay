# Guia de Contribuição

Obrigado por considerar contribuir para o projeto! Para garantir que o processo seja simples e eficiente para todos os interessados, pedimos que siga estas diretrizes antes de enviar uma contribuição.

## Como Contribuir

### Relatando Bugs

Se encontrar um bug, por favor, abra uma issue informando:

1. Uma breve descrição do problema.
2. Passos para reproduzir o problema.
3. Resultados esperados e reais.
4. Informações de ambiente, como sistema operacional e versão do Java.

### Sugestões de Funcionalidades

Caso tenha uma ideia para uma nova funcionalidade, por favor, abra uma issue com:

1. Uma descrição clara da funcionalidade.
2. Motivo pelo qual acredita que essa funcionalidade seria útil.
3. Exemplos de uso.

### Enviando Pull Requests

Para colaborar com código, siga os seguintes passos:

1. **Fork** este repositório.
2. **Clone** o seu fork:
   ```bash
   git clone https://github.com/igordmouraa/desafio_picpay
   ```
3. Crie uma nova branch para a sua alteração:
   ```bash
   git checkout -b minha-alteracao
   ```
4. Faça as alterações necessárias no código.
5. Garanta que seu código segue as boas práticas de código,
6. Adicione testes para cobrir suas alterações.
7. Garanta que todos os testes passam:
   ```bash
   mvn test
   ```
8. Faça commit de suas alterações:
   ```bash
   git commit -m "Descrição clara das alterações"
   ```
9. Envie para o seu fork:
   ```bash
   git push origin minha-alteracao
   ```
10. Abra um Pull Request no repositório original.

## Boas Práticas de Código

Para manter a qualidade do código, por favor, siga estas diretrizes:

- **Escreva testes**: Novas funcionalidades ou correções de bugs devem incluir testes.
- **Documentação**: Atualize a documentação conforme necessário.
- **Consistência de estilo**: Siga o estilo de código existente. Utilize ferramentas como o Checkstyle e o editorconfig.


## Agradecimentos

Agradecemos a todos os que contribuem para este projeto!
