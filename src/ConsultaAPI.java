import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {
    String apikey = ApiKey.getApiKey();
    public Moneda buscaMoneda(String sigla, String sigla2) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + apikey + "/pair/" + sigla + "/" + sigla2);
        System.out.println(direccion);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No se encontro la moneda a comvertir!");
        }
    }
}