import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CepService {
    public String getDadosEndereco(String cep) throws Exception{

        String cepFormatado = cep.replaceAll("[^0-9]", "");

        String apiUrl = "https://viacep.com.br/ws/" + 
        cepFormatado + "/json/";

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(apiUrl)).build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();

    }
}
