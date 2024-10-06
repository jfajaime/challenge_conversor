import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeneradorDeArchivo {
    public void guardarJson(Moneda moneda) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter escritura = new FileWriter("Moneda base: " + moneda.base_code() + ".json")) {
            escritura.write(gson.toJson(moneda));
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo JSON: " + e.getMessage());
            throw e;
        }
    }
}
