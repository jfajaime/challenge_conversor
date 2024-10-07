import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        ConsultaAPI consulta = new ConsultaAPI();
        System.out.println("Bienvenidos al Conversor De Moneda!");

        //agregar : las opciones que tiene el usuario si quiere ver elvalor base de una moneda convertida
        // a todas las que la api le devuelva o como esta actualmente devolviendo una sola conversion


        System.out.println("Ingrese la sigla de la moneda Base:");

        try {
            String sigla = teclado.nextLine();
            System.out.println("Ingrese la sigla de la moneda que desea convertir:");
            String sigla2 = teclado.nextLine();
            MonedaOmdb monedaOmdb = consulta.buscaMoneda(sigla, sigla2);
//            System.out.println("conversion " + monedaOmdb);

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
