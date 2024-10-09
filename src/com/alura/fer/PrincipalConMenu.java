package com.alura.fer;

import com.alura.fer.api.ConsultaAPI;
import com.alura.fer.modelo.MonedaOmdb;
import com.alura.fer.servicio.GeneradorDeArchivo;
import com.alura.fer.servicio.ListaSiglaDeMonedas;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class PrincipalConMenu {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        while (true) {
            mostrarMenu();
            String opcion = teclado.nextLine();

            if (opcion.equalsIgnoreCase("salir")) {
                break;
            }

            ConsultaAPI consulta = new ConsultaAPI();
            switch (opcion) {
                case "1":
                    realizarConversion(teclado, consulta, "usd", "ars"
                            , "dólares", "pesos Argentinos");
                    break;
                case "2":
                    realizarConversion(teclado, consulta, "ars", "usd"
                            , "pesos Argentinos", "dólares");
                    break;
                case "3":
                    realizarConversion(teclado, consulta, "usd", "brl"
                            , "dólares", "reales Brasileños");
                    break;
                case "4":
                    realizarConversion(teclado, consulta, "brl", "usd"
                            , "reales Brasileños", "dólares");
                    break;
                case "5":
                    realizarConversion(teclado, consulta, "usd", "mxn"
                            , "dólares", "pesos Mexicanos");
                    break;
                case "6":
                    realizarConversion(teclado, consulta, "mxn", "usd"
                            , "pesos Mexicanos", "dólares");
                    break;
                case "7":
                    ListaSiglaDeMonedas lista = new ListaSiglaDeMonedas();
                    lista.mostrarLista();
                    break;case "8":
                    System.out.println("Ingrese la sigla de la moneda Base:");
                    String sigla = teclado.nextLine();
                    System.out.println("Ingrese la sigla de la moneda que desea convertir:");
                    String sigla2 = teclado.nextLine();
                    realizarConversion(teclado, consulta, sigla, sigla2
                            , sigla, sigla2);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
        teclado.close();
    }

    private static void mostrarMenu() {
        System.out.println("""
                **********************************************************
                Elija una de las opciones de conversion o escriba "salir":
                                    
                1. Dólar => Peso Argentino
                2. Peso Argentino => Dólar
                3. Dólar => Real Brasileño
                4. Real Brasileño => Dólar
                5. Dólar => Peso Mexicano
                6. Peso Mexicano => Dólar
                7. Lista completa de las monedas admitidas para conversion!
                8. Elije entre las 160 monedas de tu preferencia disponible!
                ***********************************************************
                """);
    }

    private static void realizarConversion(Scanner teclado, ConsultaAPI consulta, String monedaOrigen, String monedaDestino, String nombreOrigen, String nombreDestino) {
        System.out.printf("Ingrese la cantidad de %s que desea convertir! >", nombreOrigen);

        double cantidad = teclado.nextDouble();
        teclado.nextLine(); // Consumir el carácter de nueva línea para no generar dos veces seguidos el menu

        MonedaOmdb monedaOmdb = consulta.buscaMoneda(monedaOrigen, monedaDestino);
        GeneradorDeArchivo generador = new GeneradorDeArchivo();
        try {
            generador.guardarJson(monedaOmdb);
        } catch (IOException e) {
        System.out.println(" No se pudo gurdar el archivo .json " + e.getMessage());
        }
        Double conversion = Double.valueOf(monedaOmdb.conversion_rate());
        NumberFormat nM = NumberFormat.getNumberInstance(Locale.GERMANY);//formato de salida
        String cantidadFormatear = nM.format(conversion * cantidad);
//        System.out.printf("Cantidad en %s es > %.2f%n", nombreDestino, conversion * cantidad);
        System.out.printf("Cantidad en %s es >$ %s%n", nombreDestino, cantidadFormatear); //mejor formato de miles
    }
}
