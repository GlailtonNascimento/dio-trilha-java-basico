import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContaTerminal {
    private static final String AGENCIA = "1234"; // Número fixo da agência
    private static Map<String, ContaBancaria> clientes = new HashMap<>();
    private static final int MAX_TENTATIVAS = 3; // Número máximo de tentativas de login
    private static final String MENSAGEM_ALERTA = "Demo e esta em teste academico feito por Glailton Nascimento"; // Mensagem de alerta

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("É o seu primeiro acesso? (sim/não):");
        String resposta = scanner.nextLine();

        if (resposta.equalsIgnoreCase("sim")) {
            criarConta(scanner);
        } else {
            System.out.print("Por favor, digite o seu CPF (somente números): ");
            String cpf = scanner.nextLine();
            efetuarLogin(cpf, scanner);
        }

        scanner.close();
    }

    private static void criarConta(Scanner scanner) {
        System.out.print("Por favor, digite o seu CPF (somente números): ");
        String cpf = scanner.nextLine();

        // Verificar se o cliente já existe
        if (!clientes.containsKey(cpf)) {
            System.out.print("Por favor, digite o seu nome: ");
            String nomeCliente = scanner.nextLine();

            // Gerar número de conta com base na agência e conta aleatória
            String numeroConta = AGENCIA + String.format("%08d", (int) (Math.random() * 100000000));
            System.out.println("Sua agência é: " + AGENCIA);
            System.out.println("Seu número de conta é: " + numeroConta);

            // Solicitar a senha do cliente
            int senha;
            do {
                System.out.print("Por favor, digite a sua senha (6 dígitos): ");
                senha = Integer.parseInt(scanner.nextLine());
                if (String.valueOf(senha).length() != 6) {
                    System.out.println("Senha inválida. A senha deve ter exatamente 6 dígitos.");
                }
            } while (String.valueOf(senha).length() != 6);

            // Criar conta bancária para o novo cliente
            ContaBancaria conta = new ContaBancaria(nomeCliente, numeroConta, senha);
            clientes.put(cpf, conta);

            System.out.println("Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco.");
            System.out.println("Sua agência é: " + AGENCIA);
            System.out.println("Seu número de conta é: " + numeroConta);
            System.out.println("Seu saldo já está disponível para operação.");

            // Após criar a conta, realizar login automaticamente
            efetuarLogin(cpf, scanner);
        } else {
            System.out.println("CPF já cadastrado. Por favor, faça login.");
            efetuarLogin(cpf, scanner);
        }
    }

    private static void efetuarLogin(String cpf, Scanner scanner) {
        if (clientes.containsKey(cpf)) {
            ContaBancaria conta = clientes.get(cpf);
            int tentativas = 0;
            while (tentativas < MAX_TENTATIVAS) {
                System.out.print("Por favor, digite a sua senha (6 dígitos): ");
                int senha = Integer.parseInt(scanner.nextLine());
                if (senha == conta.getSenhaCorreta()) {
                    conta.setLogado(true);
                    System.out.println("Logado com sucesso. Olá " + conta.getNomeCliente() + ", seu saldo é: " + conta.getSaldo());
                    System.out.println("Seu saldo já está disponível para operação.");
                    mostrarOpcoes();
                    System.out.println("Importante: " + MENSAGEM_ALERTA);
                    return;
                } else {
                    System.out.println("Senha incorreta. Tente novamente.");
                    tentativas++;
                }
            }
            System.out.println("Você excedeu o número máximo de tentativas. Por favor, recadastre sua senha.");
            conta.setSenha(0); // Resetar a senha para recadastrar
        } else {
            System.out.println("CPF não cadastrado. Por favor, crie uma conta primeiro.");
        }
    }

    private static void mostrarOpcoes() {
        System.out.println("Opções disponíveis:");
        System.out.println("1 - Saque");
        System.out.println("2 - Depósito");
        System.out.println("3 - PIX");
        System.out.println("0 - Sair");
    }

    static class ContaBancaria {
        private String nomeCliente;
        private String numeroConta;
        private int senha;
        private int senhaCorreta;
        private double saldo;
        private boolean logado;

        public ContaBancaria(String nomeCliente, String numeroConta, int senha) {
            this.nomeCliente = nomeCliente;
            this.numeroConta = numeroConta;
            this.senha = 0;
            this.senhaCorreta = senha;
            this.saldo = 0.0;
            this.logado = false;
        }

        public String getNomeCliente() {
            return nomeCliente;
        }

        public String getNumeroConta() {
            return numeroConta;
        }

        public int getSenha() {
            return senha;
        }

        public void setSenha(int senha) {
            this.senha = senha;
        }

        public int getSenhaCorreta() {
            return senhaCorreta;
        }

        public double getSaldo() {
            return saldo;
        }

        public boolean isLogado() {
            return logado;
        }

        public void setLogado(boolean logado) {
            this.logado = logado;
        }
    }
}

