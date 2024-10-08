package com.alura.fer.api;

import com.alura.fer.modelo.MonedaOmdb;
import com.google.gson.Gson;

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

//            String json = response.body();
//            System.out.println("4" + json);
//            Gson gson = new GsonBuilder().setPrettyPrinting().create();
//            MonedaOmdb monedaOmdb = gson.fromJson(json, MonedaOmdb.class);
//            System.out.println("6" + monedaOmdb);
//            Moneda moneda = new Moneda(monedaOmdb);
//            System.out.println("5" + moneda);

            return new Gson().fromJson(response.body(), MonedaOmdb.class);
        } catch (Exception e) {
            throw new RuntimeException("No se encontro la moneda a comvertir!");
        }
    }
}
