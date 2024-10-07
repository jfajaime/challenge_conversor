package com.alura.fer.servicio;

import com.alura.fer.modelo.MonedaOmdb;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeneradorDeArchivo {
    public void guardarJson(MonedaOmdb monedaOmdb) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter escritura = new FileWriter(monedaOmdb.base_code() + ".json")) {
            escritura.write(gson.toJson(monedaOmdb));
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo JSON: " + e.getMessage());
            throw e;
        }
    }
}
