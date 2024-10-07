import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {
    String apikey = ApiKey.getApiKey();

    public MonedaOmdb buscaMoneda(String sigla, String sigla2) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + apikey + "/pair/" + sigla + "/" + sigla2);
        System.out.println(direccion);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();


        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

//            System.out.println("0"+response.body()); //devuelve si paso: success y toda la imfo en esa consulta devuelta
//            System.out.println("1"+direccion);//devuelve la direccion http de la caonsulta completa con la apikey
//            System.out.println("2"+direccion.toString());//devuelve lo mismo que el sout anterior

            String json = response.body();
//            System.out.println("4" + json);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            MonedaOmdb monedaOmdb = gson.fromJson(json, MonedaOmdb.class);
            System.out.println("6" + monedaOmdb);

            Moneda moneda = new Moneda(monedaOmdb);
            System.out.println("5" + moneda);

            return new Gson().fromJson(response.body(), MonedaOmdb.class);
        } catch (Exception e) {
            throw new RuntimeException("No se encontro la moneda a comvertir!");
        }
    }
}
