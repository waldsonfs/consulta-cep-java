import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite seu CEP:");
        String cep = scanner.nextLine();

        try {

            String cepFormatado = cep.replaceAll("[^0-9]", "");

            if (cepFormatado.length() != 8) {
                System.err.println("CEP inválido. O CEP deve conter 8 dígitos.");
                scanner.close();
                return;
            }

            CepService cepService = new CepService();
            String dadosEndereco = cepService.getDadosEndereco(cepFormatado);

            if (dadosEndereco.contains("\"erro\": true")) {
                System.err.println("CEP não encontrado.");
            } else {
                CepPrinter.imprimirDadosEndereco(dadosEndereco);
            }

        } catch (Exception e) {
            System.err.println("Erro ao consultar o CEP: " + e.getMessage());
        }

        scanner.close();
    }
}