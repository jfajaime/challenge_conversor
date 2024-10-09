package com.alura.fer;

import com.alura.fer.api.ConsultaAPI;
import com.alura.fer.modelo.MonedaOmdb;
import com.alura.fer.servicio.GeneradorDeArchivo;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
//codigo ejemplo para pruebas
        ConsultaAPI consulta = new ConsultaAPI();
        System.out.println("Bienvenidos al Conversor de Moneda!");
        System.out.println("Ingrese la sigla de la moneda Base:");

        try {
            String sigla = teclado.nextLine();
            System.out.println("Ingrese la sigla de la moneda que desea convertir:");
            String sigla2 = teclado.nextLine();
            MonedaOmdb monedaOmdb = consulta.buscaMoneda(sigla, sigla2);
            System.out.println("conversion " + monedaOmdb);

            GeneradorDeArchivo generador = new GeneradorDeArchivo();
            generador.guardarJson(monedaOmdb);

        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Finalizando la aplicación!");
        } finally {
            teclado.close();
        }
    }
}
