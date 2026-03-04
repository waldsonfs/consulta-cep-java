import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite seu CEP: ");
        String CEP = scanner.nextLine();

        try {
            CepService cepservice = new CepService();
            String dadosEndereco = cepservice.getDadosEndereco(CEP);
            
            if (dadosEndereco.contains("\"code\":400")){
                System.err.println("Dados não encontrados. Insira novamente e verifique se possui 8 dígitos.");
            } else {
                CepPrinter.imprimirDadosEndereco(dadosEndereco);
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        scanner.close();
    }
}
