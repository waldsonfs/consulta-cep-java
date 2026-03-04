import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CepService {

    public String getDadosEndereco(String cep) throws Exception {

        String apiUrl = "https://viacep.com.br/ws/" + cep + "/json/";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Erro na requisição HTTP: " + response.statusCode());
        }

        return response.body();
    }
}