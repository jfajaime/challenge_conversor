import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        ConsultaAPI consulta = new ConsultaAPI();
        System.out.println("Bienvenidos al Conversor De Moneda!");


        System.out.println("Ingrese la sigla de la moneda Base:");

        try {
            String sigla = teclado.nextLine();
            System.out.println("Ingrese la sigla de la moneda que desea convertir:");
            String sigla2 = teclado.nextLine();
            Moneda moneda = consulta.buscaMoneda(sigla, sigla2);
            System.out.println(moneda);

            GeneradorDeArchivo generador = new GeneradorDeArchivo();
            generador.guardarJson(moneda);

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
