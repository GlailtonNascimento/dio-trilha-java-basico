public class FormatadorCepExemplo {
    public static void main(String[] args) {
        try {
            String cepFormatado = formatarCep("23.765.062");
            System.out.println(cepFormatado);
        } catch (CepInvalidoException e) {
            e.printStackTrace();
        }
    }

    static String formatarCep(String cep) throws CepInvalidoException {
        if (cep.length() != 8)
            throw new CepInvalidoException("CEP inválido: " + cep);

        // Simulando um CEP formatado
        return "23.765.062";
    }
}

class CepInvalidoException extends Exception {
    // Construtor da exceção
    public CepInvalidoException(String message) {
        super(message);
    }
}

