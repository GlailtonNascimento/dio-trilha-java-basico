import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class EstruturasExcepcionais {
    public static void main(String[] args) {
        try {
            // O bloco try é usado para envolver o código que pode gerar exceções.
            // Durante a execução deste bloco, qualquer exceção que ocorrer será tratada pelos blocos catch correspondentes, se houver.
            // É uma prática recomendada usar o bloco try para encapsular operações que podem lançar exceções, garantindo um tratamento adequado de erros.

            Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

            System.out.println("Digite o seu nome: ");
            String nome = scanner.next();

            System.out.println("Digite o Sobrenome: ");
            String sobrenome = scanner.next();

            System.out.println("Digite sua idade: ");
            int idade = scanner.nextInt();

            System.out.println("Digite a sua altura: ");
            double altura = scanner.nextDouble();

            // Imprimindo os dados obtidos pelo suporte
            System.out.println("Olá, me chamo " + nome.toLowerCase() + " " + sobrenome.toLowerCase());
            System.out.println("Tenho " + idade + " anos");
            System.out.println("Minha altura é " + altura + " cm");
            scanner.close();
        } catch (InputMismatchException e) {
            // O bloco catch é usado para capturar exceções específicas que ocorrem durante a execução do bloco try.
            // Neste caso, capturamos a InputMismatchException, que ocorre quando o tipo de entrada fornecida pelo usuário não corresponde ao tipo esperado pelo programa.
            // Quando essa exceção é capturada, exibimos uma mensagem amigável para o usuário, indicando que os campos idade e altura devem ser numéricos.
            // Isso ajuda a fornecer um feedback claro em casos de entrada inválida, melhorando a experiência do usuário.
            System.err.println("Os campos idade e altura precisam ser numéricos");
        }
    }
}

