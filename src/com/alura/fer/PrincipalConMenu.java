package com.alura.fer;

import com.alura.fer.api.ConsultaAPI;
import com.alura.fer.modelo.MonedaOmdb;
import com.alura.fer.servicio.ListaSiglaDeMonedas;

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
                    realizarConversion(teclado, consulta, "usd", "cop"
                            , "dólares", "pesos Colombianos");
                    break;
                case "8":
                    realizarConversion(teclado, consulta, "cop", "usd"
                            , "pesos Colombianos", "dólares");
                    break;
                case "9":
                    realizarConversion(teclado, consulta, "usd", "pen"
                            , "dólares", "soles Peruanos");
                    break;
                case "10":
                    realizarConversion(teclado, consulta, "pen", "usd"
                            , "soles Peruanos", "dólares");
                    break;
                case "11":
                    ListaSiglaDeMonedas lista = new ListaSiglaDeMonedas();
                    lista.mostrarLista();
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
                7. Dólar => Peso Colombiano
                8. Peso Colombiano => Dólar
                9. Dólar => Sol Peruano
                10. Sol Peruano => Dólar
                11. Lista completa de las monedas admitidas para conversion!
                ***********************************************************
                """);
    }

    private static void realizarConversion(Scanner teclado, ConsultaAPI consulta, String monedaOrigen, String monedaDestino, String nombreOrigen, String nombreDestino) {
        System.out.printf("Ingrese la cantidad de %s que desea convertir! >", nombreOrigen);

        double cantidad = teclado.nextDouble();
        teclado.nextLine(); // Consumir el carácter de nueva línea para no generar dos veces seguidos el menu

        MonedaOmdb monedaOmdb = consulta.buscaMoneda(monedaOrigen, monedaDestino);
        Double conversion = Double.valueOf(monedaOmdb.conversion_rate());
        NumberFormat nM = NumberFormat.getNumberInstance(Locale.GERMANY);//formato de salida
        String cantidadFormatear = nM.format(conversion * cantidad);
//        System.out.printf("Cantidad en %s es > %.2f%n", nombreDestino, conversion * cantidad);
        System.out.printf("Cantidad en %s es >$ %s%n", nombreDestino, cantidadFormatear); //mejor formato de miles
    }
}
