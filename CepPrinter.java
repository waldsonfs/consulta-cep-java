import org.json.JSONObject;

public class CepPrinter {
    public static void imprimirDadosEndereco(String dados){
        
        JSONObject dadosJson = new JSONObject(dados);
        String cep = dadosJson.getString("cep");
        String logradouro = dadosJson.getString("logradouro");
        String bairro = dadosJson.getString("bairro");
        String cidade = dadosJson.getString("localidade");
        String estado = dadosJson.getString("uf");

        System.out.println("\nInformações do Endereço:");
        System.out.println("CEP: " + cep);
        System.out.println("Logradouro: " + logradouro);
        System.out.println("Bairro: " + bairro);
        System.out.println("Cidade: " + cidade);
        System.out.println("Estado: " + estado);




    }
}
