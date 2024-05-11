# Tratamento de Exceções em Java

Neste documento, explicaremos o contexto do código Java fornecido, destacando as modificações feitas e como resolvemos o problema relacionado ao tratamento de exceções.

## Contexto

O código Java fornecido é um exemplo simples de entrada de dados do usuário (nome, sobrenome, idade e altura) e exibição desses dados. No entanto, o código original não incluía tratamento de exceções para lidar com entradas inválidas do usuário.

## Modificações Realizadas

1. **Adição de Importações de Pacotes:**
   - Importamos os pacotes `java.util.Locale`, `java.util.Scanner` e `java.util.InputMismatchException`. Isso foi necessário para utilizar classes relacionadas ao scanner de entrada e exceções de tipo mismatch.

2. **Refatoração do Nome da Classe:**
   - Renomeamos a classe de `extruturasExcepcionais` para `EstruturasExcepcionais`. Seguimos as convenções de nomenclatura Java, onde nomes de classes começam com letras maiúsculas.

3. **Adição de Comentários:**
   - Adicionamos comentários explicativos ao código. Esses comentários fornecem informações sobre o propósito de cada bloco (try, catch) e oferecem uma descrição geral do tratamento de exceções.

4. **Melhoria da Mensagem de Erro:**
   - Aprimoramos a mensagem de erro exibida no bloco catch para fornecer um feedback claro ao usuário quando ocorre uma exceção do tipo `InputMismatchException`.

## Resolução do Problema

O problema relatado estava relacionado à exceção `InputMismatchException`, que ocorre quando o tipo de entrada fornecida pelo usuário não corresponde ao tipo esperado pelo programa. Para resolver esse problema:

- Importamos a classe `InputMismatchException` do pacote `java.util`.
- Adicionamos um bloco `catch` para capturar essa exceção e exibir uma mensagem de erro amigável ao usuário, orientando-os a inserir valores numéricos para idade e altura.

## Conclusão

Com as modificações realizadas, o código Java agora inclui tratamento de exceções para lidar com entradas inválidas do usuário, garantindo uma experiência mais robusta e amigável. O código está pronto para uso e pode ser incorporado em projetos maiores ou servir como exemplo de tratamento de exceções em Java.
