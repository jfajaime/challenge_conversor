package com.alura.fer.api;

import com.alura.fer.modelo.Moneda;
import com.alura.fer.modelo.MonedaOmdb;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class ConsultaAPI {
    String apikey = ApiKey.getApiKey();

    public MonedaOmdb buscaMoneda(String sigla, String sigla2) {

        try {
            String siglaU = URLEncoder.encode(sigla, StandardCharsets.UTF_8.toString());
            String siglaU2 = URLEncoder.encode(sigla2, StandardCharsets.UTF_8.toString());

            URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + apikey + "/pair/" + siglaU + "/" + siglaU2);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            MonedaOmdb monedaOmdb = gson.fromJson(json, MonedaOmdb.class);
            Moneda miMoneda = new Moneda(monedaOmdb);

//            FileWriter escritura = new FileWriter("Historial.txt");
//            escritura.write(miMoneda.toString());
//            escritura.close();
//            System.out.println(miMoneda + "xxxx");

            return new Gson().fromJson(response.body(), MonedaOmdb.class);
        } catch (Exception e) {
            throw new RuntimeException("No se encontro la moneda a comvertir!");
        }
    }
}
